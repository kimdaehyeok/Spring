package com.spring.test.SpringDIExample;

import org.springframework.stereotype.Component;

@Component("Person")
public class Person
{
    private String name;
    private int number;
    
    public String getName()
    {
        return name;
    }
    public String setName(String name)
    {
        return this.name = name;
    }
    public int getNumber()
    {
        return number;
    }
    public int setNumber(int number)
    {
        return this.number = number;
    }
}
