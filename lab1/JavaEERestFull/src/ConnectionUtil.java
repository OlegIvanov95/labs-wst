import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Created by Oleg Satan on 23.02.2018. */

public class ConnectionUtil
{
    private static final String url  = "jdbc:mysql://localhost:3306/data",
                                user = "root",
                                pass = "root";

    static
    {
        try
        { driverRegistration(); }
        catch (Exception e)
        { Logger.getLogger(MySQLDAO.class.getName()).log(Level.SEVERE, null, e); }
    }

    /** Регистрация драйвера */
    public static void driverRegistration() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException
    { DriverManager.registerDriver(new com.mysql.jdbc.Driver());}

    // Class.forName("com.mysql.jdbc.Driver").newInstance(); }
    //oracle.jdbc.OracleDriver()
    //Class.forName("com.mysql.jdbc.Driver").newInstance();

    /** Установка соединения с DataBase */
    public static java.sql.Connection getConnection() throws SQLException
    { return getConnection(url, user, pass); }

    /** Установка соединения с DataBase */
    private static java.sql.Connection getConnection(String jdbcUrl, String user, String password) throws SQLException
    { return DriverManager.getConnection(jdbcUrl, user, password); }
}
