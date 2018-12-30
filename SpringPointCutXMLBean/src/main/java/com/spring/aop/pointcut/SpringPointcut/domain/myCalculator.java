package com.spring.aop.pointcut.SpringPointcut.domain;

public class myCalculator implements Calculator {

	public int add(int x, int y)
	{
		System.out.println("Add : " + (x + y));
		return x + y;
	}

	public int subtract(int x, int y)
	{
		System.out.println("Sub : " + (x - y));
		return x - y;
	}

	public int multiply(int x, int y) 
	{
		System.out.println("multi : " + x * y);
		return x * y;
	}

	public int divide(int x, int y)
	{
		System.out.println("div : " + x / y);
		return x / y;
	}
}
