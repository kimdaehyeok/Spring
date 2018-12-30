package com.spring.aop.advice.example.SpringAdvice.domain;

public class myCalculator implements Calculator {

	@Override
	public int add(int x, int y)
	{
		System.out.println(x + y);
		return x + y;
	}

	@Override
	public int subtract(int x, int y)
	{
		System.out.println(x + y);
		return x - y;
	}

	@Override
	public int multiply(int x, int y) 
	{
		System.out.println(x + y);
		return x * y;
	}

	@Override
	public int divide(int x, int y)
	{
		System.out.println(x + y);
		return x / y;
	}

}
