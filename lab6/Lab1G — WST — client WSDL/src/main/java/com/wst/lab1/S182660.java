package com.wst.lab1;

import com.sun.istack.internal.Nullable;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class S182660
{
    private final static String url = "http://localhost:8080/rest/humans";

    public static final int STATUS_GOOD = 0,
                            STATUS_ERROR = 1,
                            STATUS_BAD_REQUEST = 2;
    public static String getStatus(int status)
    {
        switch (status)
        {
            case STATUS_GOOD:
                return "good";
            case STATUS_ERROR:
                return "error";
            case STATUS_BAD_REQUEST:
                return "bad_request";
        }
        return "all very bad";
    }

    /** Точка входа в программу */
    public static void main(String[] args)
    {
        Client client = Client.create();

        //printList(getAllHumans(client, null));
        System.out.println();
        //printList(getAllHumans(client, 5, "Donald", "Tramp", 70, "man"));

        int ret;

        for (int i = 0; i < 20; i ++)
        {
            int finalI = i;
            new Thread(new Runnable()
            {
                @Override  public void run()
                {
                    addHuman(client, 100 + finalI, "Bill", "Klinton", 70, "man");
                }
            }).start();
        }

        System.out.println("Выполним запрос на добавление");
        ret = addHuman(client, 31, "Bill", "Klinton", 70, "man");
        System.out.print(" - успех, add id: " + ret);

        System.out.println("\n\nВыполним запрос на изменение");
        ret = changeHuman(client, 31, "Billy", "Clinton", 71, "man");
        System.out.print(" - успех, ret: " + getStatus(ret));

        System.out.println("\n\n/Выполним запрос на удаление");
        ret = removeHuman(client, 31);
        System.out.print(" - успех, ret: " + getStatus(ret));

        client.destroy();
    }

    private static List<Human> getAllHumans(Client client, @Nullable WebResource webResource)
    {
        if (webResource == null)
            webResource = client.resource(url);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode())
            throw new IllegalStateException("Request failed");

        GenericType<List<Human>> type = new GenericType<List<Human>>() {};
        return response.getEntity(type);
    }

    private static List<Human> getAllHumans(Client client, int id, String name, String surname, int age, String sex)
    {
        WebResource webResource = client.resource(url);

        webResource = webResource.queryParam("id", String.valueOf(id));
        webResource = webResource.queryParam("name", name);
        webResource = webResource.queryParam("surname", surname);
        webResource = webResource.queryParam("age", String.valueOf(age));
        webResource = webResource.queryParam("sex", sex);

        return getAllHumans(client, webResource);
    }

    private static int addHuman(Client client, int id, String name, String surname, int age, String sex)
    {
        WebResource webResource = client.resource(url + "/addHuman");

        webResource = webResource.queryParam("id", String.valueOf(id));
        webResource = webResource.queryParam("name", name);
        webResource = webResource.queryParam("surname", surname);
        webResource = webResource.queryParam("age", String.valueOf(age));
        webResource = webResource.queryParam("sex", sex);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        System.out.println("status: " + response.getStatus());

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode())
            throw new IllegalStateException("Request failed");

        GenericType<Integer> type = new GenericType<Integer>() {};
        return response.getEntity(type);
    }

    private static int removeHuman(Client client, int id)
    {
        WebResource webResource = client.resource(url + "/removeHuman");

        webResource = webResource.queryParam("id", String.valueOf(id));

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        System.out.println("status: " + response.getStatus());

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode())
            throw new IllegalStateException("Request failed");

        GenericType<Integer> type = new GenericType<Integer>() {};
        return response.getEntity(type);
    }

    private static int changeHuman(Client client, int id, String name, String surname, int age, String sex)
    {
        WebResource webResource = client.resource(url + "/changeHuman");

        webResource = webResource.queryParam("id", String.valueOf(id));
        webResource = webResource.queryParam("name", name);
        webResource = webResource.queryParam("surname", surname);
        webResource = webResource.queryParam("age", String.valueOf(age));
        webResource = webResource.queryParam("sex", sex);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        System.out.println("status: " + response.getStatus());

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode())
            throw new IllegalStateException("Request failed");

        GenericType<Integer> type = new GenericType<Integer>() {};
        return response.getEntity(type);
    }

    /** Выводит лист на экран */
    private static void printList(List<Human> humans)
    {
        System.out.println("printList");
        for (Human human : humans)
            System.out.println(human.id + " " + human.name + '\t' + human.surname + '\t' + human.age + '\t' + human.sex);
        System.out.println("-------------------------------");
    }
}