import com.sun.istack.internal.Nullable;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Created by Oleg Satan on 23.02.2018. */

@WebService (serviceName = "PersonService")
public class PersonWebService
{
    @Resource(lookup = "jdbc/data")
    private DataSource dataSource;

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

    private Connection getConnection()
    {
        Connection result = null;
        try
        { result = dataSource.getConnection(); }
        catch (SQLException ex)
        { Logger.getLogger(PersonWebService.class.getName()).log(Level.SEVERE, null, ex); }

        return result;
    }
}
