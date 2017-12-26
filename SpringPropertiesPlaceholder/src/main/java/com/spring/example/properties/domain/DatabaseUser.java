package com.spring.example.properties.domain;

import org.springframework.beans.factory.annotation.Value;

public class DatabaseUser 
{
	private String name;
	private String password;
	
	@Value("${jdbc.database}")
	private String database;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
//	public String getDatabase() 
//	{
//		return database;
//	}
//	public void setDatabase(String database) 
//	{
//		this.database = database;
//	}
	
	public void show()
	{
		System.out.println(name + " " + password + " " + database);
	}
}
