package com.example.demo.runnable;

public class ThreadTest 
{
	public static void main(String[] args) 
	{
		Student huni = new Student("abc", 20,"computer");
		Student mini = new Student("dce", 21, "network");
		
		Thread huni_thread = new Thread(huni);
		Thread mini_thread = new Thread(mini);
		
		huni_thread.start();
		mini_thread.start();
	}
}
