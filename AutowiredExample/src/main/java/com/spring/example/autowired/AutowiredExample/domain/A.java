package com.spring.example.autowired.AutowiredExample.domain;

public class A 
{
	private B b1;
	
	public B getB()
	{
		return b1;
	}
	
	public void setB(B b)
	{
		this.b1 = b;
	}
	
	public void print()
	{
		System.out.println("Hello A");
	}
	
	public void display()
	{
		print();
		b1.print();
	}	
}
