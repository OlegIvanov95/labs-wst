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
    @GET public List<Human> getHumans(@QueryParam("id")  int id,  @QueryParam("name") String name, @QueryParam("surname") String surname,
                                      @QueryParam("age") int age, @QueryParam("sex")  String sex)
    { return new MySQLDAO().getHumans(id, name, surname, age, sex); }

    /** Добавляет запись в базу данных, берёт на вход значения всех полей записи
      * @return возвращает id новой записи */
    @Path("/addHuman")
    @GET public int addHuman(@QueryParam("id")  int id,  @QueryParam("name") String name, @QueryParam("surname") String surname,
                             @QueryParam("age") int age, @QueryParam("sex")  String sex)  throws IncorrectIdException
    {
        if (id < 0)
            throw new IncorrectIdException("id меньше 0");

        return new MySQLDAO().addHuman(id, name, surname, age, sex);
    }

    /** Удаляет запись по её id
      * @return возвращает статус операции */
    @Path("/removeHuman")
    @GET public int removeHuman(@QueryParam("id") int id) throws IncorrectIdException
    {
        if (id < 0)
            throw new IncorrectIdException("id меньше 0");

        return new MySQLDAO().removeHuman(id);
    }

    /** Изменяет запись в базе, берёт на вход id изменяемой записи и новые поля
      * @return возвращает статус операции */
    @Path("/changeHuman")
    @GET public int changeHuman(@QueryParam("id")  int id, @QueryParam("name") String name, @QueryParam("surname") String surname,
                                @QueryParam("age") int age, @QueryParam("sex") String sex)  throws IncorrectIdException
    {
        if (id < 0)
            throw new IncorrectIdException("id меньше 0");

        return new MySQLDAO().changeHuman(id, name, surname, age, sex);
    }
}
