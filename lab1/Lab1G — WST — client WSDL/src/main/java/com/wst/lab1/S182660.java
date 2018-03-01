package com.wst.lab1;

import mypackage.*;
import mypackage.Person;

import java.net.MalformedURLException;
import java.net.URL;/* 0. Создать объект типа DataSource и сохранить его, используя JNDI; запросить сохраненный объект и получить,
      используя его, соединение с базой данных; выполнить запрос методом execute(), используя объект типа
      Statement; при выводе результатов использовать метод next(). */
import java.util.List;

public class S182660
{
    /** Точка входа в программу */
    public static void main(String[] args)
    {
        String url = "http://localhost:8080/PersonWebService?wsdl";

        try
        {
            PersonService personService = new PersonService(new URL(url));

            /*List<Person> persons = personService.getPersonWebServicePort().getPersons();

            for (Person person : persons)
                System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());*/

            List<Human> humans = personService.getPersonWebServicePort().getHumans2(null , null, null, 22, "man");

            System.out.println("Таблица\n------------------------------");
            for (Human human : humans)
                System.out.println(human.getId() + "\t" + human.getName() + "\t" + human.getSurname()
                                                 + "\t" + human.getAge()  + "\t" + human.getSex());
        }
        catch (MalformedURLException e)
        { e.printStackTrace(); }
    }


}