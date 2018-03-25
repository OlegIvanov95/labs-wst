import javax.annotation.Resource;
//import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


//@RequestScoped
@Path("/humans")
@Produces({MediaType.APPLICATION_JSON/*, MediaType.APPLICATION_XML*/})
public class HumanResource
{
    @Resource(lookup = "jdbc/data")
    private DataSource dataSource;

    @GET
    public List<Human> getHumans(@QueryParam("id") int id, @QueryParam("name") String name,
                                 @QueryParam("surname") String surname, @QueryParam("age") int age, @QueryParam("sex") String sex)
    {
        MySQLDAO dao = new MySQLDAO();
        List<Human> humans = dao.getHumans(id, name, surname, age, sex);

        return humans;
    }

    private Connection getConnection()
    {
        Connection result = null;
        try
        { result = dataSource.getConnection(); }
        catch (SQLException ex)
        { Logger.getLogger(HumanResource.class.getName()).log(Level.SEVERE, null, ex); }
        return result;
    }
}
