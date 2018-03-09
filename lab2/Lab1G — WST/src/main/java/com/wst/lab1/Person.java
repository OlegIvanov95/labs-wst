package com.wst.lab1;

/** Created by Oleg Satan on 23.02.2018. */
public class Person
{
    private int id;
    private String name;
    private String surname;
    private int age;

    public Person()
    { }

    public Person(String name, String surname, int age)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId()
    { return id; }

    public String getName()
    { return name; }

    public String getSurname()
    { return surname; }

    public int getAge()
    { return age; }

    public void setName(String name)
    { this.name = name; }

    public void setSurname(String surname)
    { this.surname = surname; }

    public void setAge(int age)
    { this.age = age; }

    @Override public String toString()
    { return "com.wst.lab1.Person{" + "id=" + id + "name=" + name + ", surname=" + surname + ", age=" + age + '}'; }
}