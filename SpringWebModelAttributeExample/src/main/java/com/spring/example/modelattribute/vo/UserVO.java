package com.spring.example.modelattribute.vo;

public class UserVO 
{
	private String userName;
	private String address;
	private String fruit;

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getFruit()
	{
		return fruit;
	}

	public void setFruit(String fruit)
	{
		this.fruit = fruit;
	}

	public String toString()
	{
		return "UserVO [userName=" + userName + ", address=" + address + ", fruit=" + fruit + "]";
	}
}
