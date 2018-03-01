package com.wst.lab1;

import com.sun.istack.internal.Nullable;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/** Created by Oleg Satan on 23.02.2018. */

@WebService (serviceName = "PersonService")
public class PersonWebService
{
    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons()
    {
        MySQLDAO dao = new MySQLDAO();
        List<Person> persons = dao.getPersons();
        return persons;
    }

    @WebMethod(operationName = "getHumans")
    public List<Human> getHumans()
    {
        MySQLDAO dao = new MySQLDAO();
        List<Human> humans = dao.getHumans();
        return humans;
    }

    @WebMethod(operationName = "getHumans2")
    public List<Human> getHumans(@Nullable Integer id, @Nullable String name, @Nullable String surname, @Nullable Integer age, @Nullable String sex)
    {
        MySQLDAO dao = new MySQLDAO();
        List<Human> humans = dao.getHumans(id, name, surname, age, sex);
        return humans;
    }
}
