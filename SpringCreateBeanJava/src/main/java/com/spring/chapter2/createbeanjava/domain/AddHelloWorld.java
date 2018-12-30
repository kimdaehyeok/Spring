package com.spring.chapter2.createbeanjava.domain;

public class AddHelloWorld 
{
	public AddHelloWorld(HelloWorld helloworld)
	{
		System.out.println("Add Hello World");
		
		helloworld.whoAmI();
	}
	
	public void addHelloWhoami()
	{
		System.out.println("I am a Add Hello");
	}
}
