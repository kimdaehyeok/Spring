package com.spring.chapter2.createbeanjava.domain;

public class HelloWorld 
{
	private String seperator;
	
	public HelloWorld(String seperator)
	{
		this.seperator = seperator;
	}
	
	public void whoAmI()
	{
		System.out.println("Hello World Class : " + seperator);
	}
}
