package com.wst.lab1;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.sun.istack.internal.NotNull;
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
    public static final int STATUS_GOOD = 0,
                            STATUS_ERROR = 1,
                            STATUS_BAD_REQUEST = 2;

    /*public List<Person> getPersons()
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
    }*/

    /** Добавляет запись в базу данных, берёт на вход значения всех полей записи
      * @return возвращает id новой записи */
    public int addHuman(@Nullable Integer id, @Nullable String name, @Nullable String surname, @Nullable Integer age, @Nullable String sex) /*throws IncorrectIdException, NullHumanException*/
    {
        /*if (human == null)
        {
            PersonServiceFault fault = PersonServiceFault.defaultInstance();
            throw new NullHumanException("human - is null", fault);
        }*/

        try
        {
            final String query = String.format("INSERT INTO humans VALUES('%d', '%s', '%s', '%d', '%s');", id, name, surname, age, sex);
            System.out.print("Execute: " + query);

            Connection conn = ConnectionUtil.getConnection();
            Statement st = conn.createStatement();

            st.executeUpdate(query);

            System.out.println(" - good");

            return id;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        /*catch (Exception e)
        {
            if (e.getMessage().contains("Duplicate") && e instanceof MySQLIntegrityConstraintViolationException)
            {
                PersonServiceFault fault = PersonServiceFault.defaultInstance();
                throw new IncorrectIdException("id exist - duplicate entry " + human.id, fault, e);
            }
            else
            {
                System.out.println(" - bad");
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return -1;
    }

    /** Удаляет запись по её id
      * @return возвращает статус операции */
    public int removeHuman(int id)
    {
        try
        {
            final String query = "DELETE FROM humans WHERE id = " + id;
            System.out.print("Execute: " + query);

            Connection conn = ConnectionUtil.getConnection();
            Statement st = conn.createStatement();

            st.executeUpdate(query);
            System.out.println(" - good");

            return STATUS_GOOD;
        }
        catch (Exception e)
        {
            System.out.println(" - bad");
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return STATUS_ERROR;
    }


    /** Изменяет запись в базе, берёт на вход id изменяемой записи и новые поля
      * @return возвращает статус операции */

    public int changeHuman(@Nullable Integer id, @Nullable String name, @Nullable String surname, @Nullable Integer age, @Nullable String sex)
    {
        /*if (human == null)
        {
            PersonServiceFault fault = PersonServiceFault.defaultInstance();
            throw new NullHumanException("human - is null", fault);
        }*/

        try
        {
            final String query = String.format(
                "UPDATE humans" +
                        " SET name = '%s'," +
                            " surname = '%s'," +
                            " age = '%d'," +
                            " sex = '%s'" +
                    " WHERE id = '%d';",
                                        name, surname, age, sex, id);

            System.out.print("Execute: " + query);

            Connection conn = ConnectionUtil.getConnection();
            Statement st = conn.createStatement();

            st.executeUpdate(query);
            System.out.println(" - good");

            return STATUS_GOOD;
        }
        catch (Exception e)
        {
            System.out.println(" - bad");
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return STATUS_ERROR;
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
