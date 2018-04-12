package com.wst.lab1;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import java.io.IOException;
import java.sql.*;

/* 0. Создать объект типа DataSource и сохранить его, используя JNDI; запросить сохраненный объект и получить,
      используя его, соединение с базой данных; выполнить запрос методом execute(), используя объект типа
      Statement; при выводе результатов использовать метод next(). */

public class S182660
{
    private static HttpServer server;

    /** Выводит всю таблицу на экран */
    private static void printAllTable(Connection conn, String tabName) throws SQLException
    {
        Statement st = conn.createStatement();
        String sqlQuery = "SELECT * FROM " + tabName;

        System.out.println("Query: " + sqlQuery);
        ResultSet rs = st.executeQuery(sqlQuery);

        printTableFromResult(rs);

        st.close();
    }

    /** Просто выводит таблицу */
    private static void printTableFromResult(ResultSet rs) throws SQLException
    {
        final int INIT_SIZE = 32;
        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();

        // по хорошему надо StringBuilder вместо String
        StringBuilder tabHeader = new StringBuilder(INIT_SIZE);
        for (int i = 1; i <= colCount; i++)
            tabHeader.append(rsmd.getColumnName(i)).append('\t');

        System.out.println(tabHeader);
        System.out.println("----------------------------------------------------------------------------------------------------");

        while(rs.next())
        {
            StringBuilder row = new StringBuilder(INIT_SIZE);

            for (int i = 1; i <= colCount; i++)
                row.append(rs.getString(i)).append('\t');

            System.out.println(row);
        }

        rs.close();
    }

    /** Точка входа в программу */
    public static void main(String[] args)
    {
        String url = "http://localhost:8080/rest";

        try
        {
            //ResourceConfig resourceConfig = new ClassNamesResourceConfig(HumanResource.class);
            ResourceConfig resourceConfig = new
                           PackagesResourceConfig(S182660.class.getPackage().getName());

            server = GrizzlyServerFactory.createHttpServer(url, resourceConfig);
            server.start();
            System.out.println("Сервер запущен " + url);

            System.in.read();
            stopServer();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            stopServer();

            System.out.println("Ошибка, сервер остановлен");
        }
    }

    /** Останавливает сервер и очищает переменную */
    private static void stopServer()
    {
        if (server != null)
        {
            server.stop();
            server = null;
        }
    }

    /** Выполняет тестовый запрос для проверки наличия БД */
    public static void testDBConnected()
    {
        try
        {
            ConnectionUtil.driverRegistration();
            Connection conn = ConnectionUtil.getConnection();

            printAllTable(conn, "persons");

            System.out.println("\nКонец\n");
        }
        catch (Exception e)
        {
            System.out.println("\nМы искренне приносим свои глубочайшие извинения за следующую ошибку: ");
            e.printStackTrace();
        }
    }
}