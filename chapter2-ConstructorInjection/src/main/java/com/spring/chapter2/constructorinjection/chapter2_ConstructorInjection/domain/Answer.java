package com.spring.chapter2.constructorinjection.chapter2_ConstructorInjection.domain;

public class Answer 
{
	private int id;
	private String name;
	private String by;
	
	public Answer() {}
	
	public Answer(int id, String name, String by)
	{
		this.id = id;
		this.name = name;
		this.by = by;
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
	public String getBy() 
	{
		return by;
	}
	public void setBy(String by) 
	{
		this.by = by;
	}
	
	public String toString()
	{
		return id + " " + name + " " + by;
	}
}
