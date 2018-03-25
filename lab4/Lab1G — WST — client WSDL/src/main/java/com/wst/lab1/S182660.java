package com.wst.lab1;

import com.sun.istack.internal.Nullable;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.util.List;

public class S182660
{
    private final static String url = "http://localhost:8080/rest/humans";

    /** Точка входа в программу */
    public static void main(String[] args)
    {
        Client client = Client.create();
        printList(getAllHumans(client, null));
        System.out.println();
        printList(getAllHumans(client, 5, "Donald", "Tramp", 70, "man"));
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

    /** Выводит лист на экран */
    private static void printList(List<Human> humans)
    {
        System.out.println("printList");
        for (Human human : humans)
            System.out.println(human.id + " " + human.name + '\t' + human.surname + '\t' + human.age + '\t' + human.sex);
        System.out.println("-------------------------------");
    }

}