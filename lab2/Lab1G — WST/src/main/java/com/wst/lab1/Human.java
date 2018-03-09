package com.wst.lab1;

public class Human
{
    public int id;
    public String name;
    public String surname;
    public int age;
    public String sex;

    public Human(int id, String name, String surname, int age, String sex)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    /** Выводит описание человека */
    public String getHumanDescribe()
    { return (id + "\t" + name + "\t" + surname + "\t" + age + "\t" + sex); }
}
