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
    public List<Person> getPersons()
    {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection())
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from persons");
            while (rs.next())
            {
                int id = rs.getInt("id_user");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                Person person = new Person(name, surname, age);
                persons.add(person);
            }
        }
        catch (SQLException ex)
        { Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex); }
        return persons;
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
        catch (SQLException ex)
        { Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex); }
        return humans;
    }

    public List<Human> getHumans(@Nullable Integer id, @Nullable String name, @Nullable String surname, @Nullable Integer age, @Nullable String sex)
    {
        // Знаю что это не оптимально, но для первой лабы пока лень менять
        // Конечно надо делать WHERE опциональный
        List<Human> allHumans, selectedHumans;

        allHumans = getHumans();
        selectedHumans = new ArrayList<>();

        for (Human human : allHumans)
        {
            if (id == null || human.id == id)
            if (name == null || human.name.equals(name))
            if (surname == null || human.surname.equals(surname))
            if (age == null || human.age == age)
            if (sex == null || human.sex.equals(sex))
                selectedHumans.add(human);
        }

        return selectedHumans;
    }
}
