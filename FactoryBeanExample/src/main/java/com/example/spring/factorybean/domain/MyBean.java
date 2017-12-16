package com.example.spring.factorybean.domain;

public class MyBean 
{
	private String getInitString;
	
	public MyBean(String getInitString)
	{
		this.getInitString = getInitString;
	}
	
	public MyBean()
	{
		System.out.println("The Object of MyBean is created");
	}
	
	public void doTask()
	{
		System.out.println("getInitString : " + getInitString );
		System.out.println("Do Task");
	}
}
