package com.example.demo.priority;

public class ThreadTest 
{
	public static void main(String[] args) 
	{
		ThreadPriority tp1 = new ThreadPriority("tp1", 10);
		ThreadPriority tp2 = new ThreadPriority("tp2", 5);
		ThreadPriority tp3 = new ThreadPriority("tp3", 1);
		
		tp1.start();
		tp2.start();
		tp3.start();
	}
}
