import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.sun.istack.internal.Nullable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Created by Oleg Satan on 23.02.2018. */

public class MySQLDAO
{
    public List<Human> getHumans(String name)
    {
        List<Human> humans = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection())
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from humans");
            while (rs.next())
            {
                String rsName = rs.getString("name");

                if (name == null || name.length() == 0 || name.equals(rsName))
                    humans.add(new Human(rs.getInt("id"),
                            rsName,
                            rs.getString("surname"),
                            rs.getInt("age"),
                            rs.getString("sex")));
            }
        }
        catch (SQLException e)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return humans;
    }

    public List<Human> getHumans()
    {
        List<Human> humans = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection())
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from humans");
            while (rs.next())
            {
                humans.add(new Human(rs.getInt("id"),
                                     rs.getString("name"),
                                     rs.getString("surname"),
                                     rs.getInt("age"),
                                     rs.getString("sex")));
            }
        }
        catch (SQLException e)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return humans;
    }

    public List<Human> getHumans(@Nullable Integer id, @Nullable String name, @Nullable String surname, @Nullable Integer age, @Nullable String sex)
    {
        // Знаю что это не оптимально, но пока лень менять
        // Конечно надо делать WHERE опциональный
        List<Human> allHumans, selectedHumans;

        allHumans = getHumans();
        selectedHumans = new ArrayList<>();

        for (Human human : allHumans)
        {
            if (id == null || human.id != 0 || human.id == id)
            if (name == null || human.name.equals(name))
            if (surname == null || human.surname.equals(surname))
            if (age == null || human.age != 0 || human.age == age)
            if (sex == null || human.sex.equals(sex))
                selectedHumans.add(human);
        }

        return selectedHumans;
    }
}
