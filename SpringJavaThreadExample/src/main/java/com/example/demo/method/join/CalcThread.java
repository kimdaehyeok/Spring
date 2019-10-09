package com.example.demo.method.join;

public class CalcThread extends Thread 
{
	private int num1;
	private int num2;
	private int result;
	
	public CalcThread(int num1, int num2)
	{
		this.num1 = num1;
		this.num2 = num2;
		
		result = 0;
	}
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		result = num1 + num2;
	}
	
	public int getResult()
	{
		return result;
	}
}
