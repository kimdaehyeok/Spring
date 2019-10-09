package com.example.demo.runnable;

public class Student extends Human implements Runnable 
{
	private String subject;
	
	public Student(String name, int age, String subject) 
	{
		super(name, age);
		// TODO Auto-generated constructor stub
		this.subject = subject;
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i ++)
		{
			System.out.println("제 이름은 " + getName());
			System.out.println("제 나이는 " + getAge());
			System.out.println("제 전공은 " + subject);
			
			System.out.println("================");
			
			try 
			{
				Thread.sleep(150);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
