package com.wst.lab1;

import mypackage.*;
import mypackage.Person;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class S182660
{
    private final static String url = "http://localhost:8080/PersonWebService?wsdl";

    /** Точка входа в программу */
    public static void main(String[] args)
    {
        try
        {
            PersonService personService = new PersonService(new URL(url));

            //testConnection();

            System.out.print("Выполним запрос на добавление");
            final int ret = personService.getPersonWebServicePort().addHuman(15, "Ekaterina", "Morozova", 25, "woman");
            System.out.print(" - успех, ret: " + ret);

            System.out.print("Выполним запрос на изменение");
            final Status status2 = personService.getPersonWebServicePort().changeHuman(ret, "Katya", "Moroz", 21, "woman");
            System.out.print(" - успех, ret: " + getStatus(status2));

           /* System.out.print("Выполним запрос на удаление");
            final Status status = personService.getPersonWebServicePort().removeHuman(ret);

            System.out.print(" - успех, ret: " + getStatus(status));*/
        }
        catch (MalformedURLException e)
        { e.printStackTrace(); }
    }

    private static String getStatus(Status status)
    {
        switch (status)
        {
            case GOOD:
                return "Good";
            case ERROR:
                return "Error";
            case BAD_REQUEST:
                return "Bad request";
            default:
                return null;
        }
    }

    /** Тестирует подключение к БД с помощью тестового запроса */
    private static void testConnection() throws MalformedURLException
    {
        PersonService personService = new PersonService(new URL(url));

        List<Person> persons = personService.getPersonWebServicePort().getPersons();

        /*for (Person person : persons)
            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());*/

            List<Human> humans = personService.getPersonWebServicePort().getHumans2(null , null, null, 22, "man");

            System.out.println("Таблица\n------------------------------");
            for (Human human : humans)
                System.out.println(human.getId() + "\t" + human.getName() + "\t" + human.getSurname()
                                                 + "\t" + human.getAge()  + "\t" + human.getSex());
    }


}