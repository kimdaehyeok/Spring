package com.example.demo.priority;

class ThreadPriority extends Thread 
{
	private String name;
	
	ThreadPriority(String name, int priority)
	{
		this.name = name;
		setPriority(priority);
	}
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		for(int i = 0; i < 3; i ++)
		{
			System.out.println(name + "쓰레드 우선순위 : " + getPriority());
		}
	}
}