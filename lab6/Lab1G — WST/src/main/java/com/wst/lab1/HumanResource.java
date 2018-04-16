package com.wst.lab1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/** REST-ресурс  */
@Path("/humans")
@Produces({MediaType.APPLICATION_JSON/*, MediaType.APPLICATION_XML*/})
public class HumanResource
{
    final static int MAX_QUERY_COUNT = 8;
    static int queryCount;

    private void addQuery()
    {
        synchronized(HumanResource.class)
        {
            queryCount++;
            System.out.println("addQuery: " + queryCount);
        }
    }

    private void removeQuery()
    {
        synchronized(HumanResource.class)
        {
            queryCount--;
            System.out.println("removeQuery: " + queryCount);
        }
    }

    private void checkQuery() throws ThrottlingException
    {
        if (queryCount < MAX_QUERY_COUNT)
            addQuery();
        else
        {
            System.out.println("LIMIT_REACHED: " + queryCount);
            throw new ThrottlingException("too much");
        }
    }

    @GET public List<Human> getHumans(@QueryParam("id")  int id,  @QueryParam("name") String name, @QueryParam("surname") String surname,
                                      @QueryParam("age") int age, @QueryParam("sex")  String sex) throws ThrottlingException
    {
        checkQuery();

        List<Human> list = new MySQLDAO().getHumans(id, name, surname, age, sex);

        removeQuery();

        return list;
    }

    /** Добавляет запись в базу данных, берёт на вход значения всех полей записи
      * @return возвращает id новой записи */
    @Path("/addHuman")
    @GET public int addHuman(@QueryParam("id")  int id,  @QueryParam("name") String name, @QueryParam("surname") String surname,
                             @QueryParam("age") int age, @QueryParam("sex")  String sex) throws IncorrectIdException, ThrottlingException
    {
        checkQuery();

        if (id < 0)
            throw new IncorrectIdException("id меньше 0");

        int ret = new MySQLDAO().addHuman(id, name, surname, age, sex);

        removeQuery();

        return ret;
    }

    /** Удаляет запись по её id
      * @return возвращает статус операции */
    @Path("/removeHuman")
    @GET public int removeHuman(@QueryParam("id") int id) throws IncorrectIdException, ThrottlingException
    {
        checkQuery();

        if (id < 0)
            throw new IncorrectIdException("id меньше 0");

        int ret = new MySQLDAO().removeHuman(id);

        removeQuery();

        return ret;
    }

    /** Изменяет запись в базе, берёт на вход id изменяемой записи и новые поля
      * @return возвращает статус операции */
    @Path("/changeHuman")
    @GET public int changeHuman(@QueryParam("id")  int id, @QueryParam("name") String name, @QueryParam("surname") String surname,
                                @QueryParam("age") int age, @QueryParam("sex") String sex)  throws IncorrectIdException, ThrottlingException
    {
        checkQuery();

        if (id < 0)
            throw new IncorrectIdException("id меньше 0");

        int ret = new MySQLDAO().changeHuman(id, name, surname, age, sex);

        removeQuery();

        return ret;
    }
}
