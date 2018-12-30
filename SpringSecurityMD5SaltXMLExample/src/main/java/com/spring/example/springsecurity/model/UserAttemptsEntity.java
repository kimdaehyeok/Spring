package com.spring.example.springsecurity.model;

import java.util.Date;

public class UserAttemptsEntity 
{
	private String username;
	private int attempts;
	private Date lastModified;
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public int getAttempts()
	{
		return attempts;
	}
	public void setAttempts(int attempts) 
	{
		this.attempts = attempts;
	}
	public Date getLastModified() 
	{
		return lastModified;
	}
	public void setLastModified(Date lastModified) 
	{
		this.lastModified = lastModified;
	}
}
