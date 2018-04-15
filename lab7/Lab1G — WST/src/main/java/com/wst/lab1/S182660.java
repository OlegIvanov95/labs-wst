package com.wst.lab1;

public class S182660
{
    private static String username = "oleg";
    private static String password = "oleg";

    /** Точка входа в программу */
    public static void main(String[] args)
    {
        // TODO проверить args

        boolean isFind;

        try
        {
            int i = Integer.valueOf(args[0]);

            if (i == 0)
                isFind = true;
            else if (i == 1)
                isFind = false;
            else
                throw new Exception("");
        }
        catch (Exception e)
        {
            System.out.println("Неверный параметр !");
            return;
        }

        // поиск
        if (isFind)
        {
            if (args.length < 2)
                System.out.println("Отсутствует имя бизнеса");

            (new SimpleBrowse()).browse(username, password, args[1]);
        }
        // создание
        else
        {
            if (args.length < 3)
                System.out.println("Отсутствует имя бизнеса и/или сервиса");

            (new SimplePublishPortable()).publish(username, password, args[1], args[2]);
        }

    }


}