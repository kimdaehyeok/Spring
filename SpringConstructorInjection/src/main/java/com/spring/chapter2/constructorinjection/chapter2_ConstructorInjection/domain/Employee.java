package com.spring.chapter2.constructorinjection.chapter2_ConstructorInjection.domain;

import java.util.List;

public class Employee 
{
	private int id;  
	private String name;
	private String pass;
	private Address address;
	private List<String> answers;
	
	public Employee(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public Employee(int id, String name, Address address)
	{
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Employee(int id, String name, List<String> answers)
	{
		this.id = id;
		this.name = name;
		this.answers = answers;
	}
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}  
	
	public String getPass() 
	{
		return pass;
	}

	public void setPass(String pass) 
	{
		this.pass = pass;
	}
	
	public List<String> getAnswers()
	{
		return answers;
	}

	public void setAnswers(List<String> answers) 
	{
		this.answers = answers;
	}

	public void show()
	{
		System.out.println(id + " " + name);
	}
	
	public void addressShow()
	{
		System.out.println(id + " " + name + " " + address.getCity() + " " + pass);
	}
	
	public void listShow() 
	{
		System.out.println(id + " " + name + " ");
		
		for(String answer : answers)
		{
			System.out.println("answers : " + answer);
		}
	}
	
	public void inheritShow()
	{
		System.out.println(id + " " + name);
		System.out.println(address.toString());
	}
}
