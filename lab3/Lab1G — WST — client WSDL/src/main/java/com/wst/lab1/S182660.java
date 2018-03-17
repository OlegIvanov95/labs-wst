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
            new Thread(new Runnable()
            {
                @Override public void run()
                {
                    try
                    {
                        System.out.println("*threadRun");
                        PersonService personService = new PersonService(new URL(url));

                        //testConnection();

                        System.out.println("Выполним запрос на добавление");

                        Human human = new Human();
                        human.setId(15);
                        human.setName("Ekaterina");
                        human.setSurname("Morozova");
                        human.setAge(25);
                        human.setSex("woman");

                        int ret = -10;
                        try
                        {
                            ret = personService.getPersonWebServicePort().addHuman(human);
                            System.out.print(" - успех, ret: " + ret);
                        }
                        catch (IncorrectIdException | NullHumanException e)
                        { e.printStackTrace(); }

                        System.out.println("Выполним запрос на изменение");

                        Human human2 = new Human();
                        human2.setId(ret);
                        human2.setName("Katya");
                        human2.setSurname("Moroz");
                        human2.setAge(21);
                        human2.setSex("woman");

                        try
                        {
                            final Status status2 = personService.getPersonWebServicePort().changeHuman(human2);
                            System.out.print(" - успех, ret: " + getStatus(status2));
                        }
                        catch (NullHumanException e)
                        { e.printStackTrace(); }

                        System.out.println("Выполним запрос на удаление");
                        final Status status = personService.getPersonWebServicePort().removeHuman(ret);

                        System.out.print(" - успех, ret: " + getStatus(status));
                        System.out.println("*threadStop");
                    }
                    catch (MalformedURLException e)
                    { e.printStackTrace(); }
                }
            }).start();

        System.out.println("*other methods");
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