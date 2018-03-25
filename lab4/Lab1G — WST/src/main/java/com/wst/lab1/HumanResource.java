package com.wst.lab1;

import com.sun.istack.internal.Nullable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/** REST-ресурс  */
@Path("/humans")
@Produces({MediaType.APPLICATION_JSON/*, MediaType.APPLICATION_XML*/})
public class HumanResource
{
    /*@GET
    public List<Human> getHumans(@QueryParam("human") String human)
    {
        MySQLDAO dao = new MySQLDAO();
        List<Human> humans = dao.getHumans(human);

        return humans;
    }*/

    @GET
    public List<Human> getHumans(@QueryParam("id") int id, @QueryParam("name") String name,
    @QueryParam("surname") String surname, @QueryParam("age") int age, @QueryParam("sex") String sex)
    {
        MySQLDAO dao = new MySQLDAO();
        List<Human> humans = dao.getHumans(id, name, surname, age, sex);

        return humans;
    }
}
