package com.spring.example.aop.xml.domain;

public class Operation 
{
	public void msg()
	{
		System.out.println("This is msg Method");
	}
	
	public int m()
	{
		System.out.println("This is m Method");
		
		return 2;
	}
	
	public int k()
	{
		System.out.println("This is k Method");
		
		return 3;
	}
	
	public void validate(int age)
	{
		if(age > 18)
		{
			System.out.println("validate");
		}
		else
		{
			throw new ArithmeticException("Not Valid Age");
		}
	}
}
