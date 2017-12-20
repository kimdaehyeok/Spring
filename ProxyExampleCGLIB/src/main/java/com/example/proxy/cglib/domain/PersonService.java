package com.example.proxy.cglib.domain;

public class PersonService 
{
	public String sayHello(String name)
	{
		System.out.println(" - PersonService Say Hello Method");
		return "Hello " + name;
	}
	
	public int lengthOfName(String name)
	{
		return name.length();
	}
}
