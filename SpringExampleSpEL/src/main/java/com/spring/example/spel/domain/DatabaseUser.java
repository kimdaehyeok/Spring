package com.spring.example.spel.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class DatabaseUser 
{
	private String name;
	private String password;
	
	@Value("#{db['jdbc.database']}")
	private String database;
	
	@Value("#{itemBean.name}")
	private String getValueFromBean;
	
	@Value("#{itemBean}")
	private Item getObjectFromBean;
	
	@Value("${file_dir.url}")
	private String valueError;
	
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
	public String getDatabase() 
	{
		return database;
	}
	public void setDatabase(String database) 
	{
		this.database = database;
	}
	
	public void show()
	{
		System.out.println(name + " " + password + " " + database + " " + getValueFromBean + " " + getObjectFromBean.whoAmI() + " " + valueError );
	}
}
