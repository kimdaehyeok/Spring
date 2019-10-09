package com.example.demo.thread;

public class FruitRunnable implements Runnable 
{
	private String name;

	public FruitRunnable(String name) 
	{
		this.name = name;
	}

	/* run()을 오버라이드 하며 여기에 실행될 코드를 입력한다. */
	@Override
	public void run() 
	{
		System.out.println(Thread.currentThread().getName());
		
		for (int i = 0; i < 5; i++) 
		{
			System.out.println("Thread Name : " + name + "쓰레드 입니다.");
			
			try 
			{
				Thread.sleep(150);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) 
	{
		FruitThread apple = new FruitThread("Apple");
		FruitThread banana = new FruitThread("Banana");

		Thread apple_thread = new Thread(apple);
		Thread banana_thread = new Thread(banana);
		
		apple_thread.run();
		banana_thread.start();
	}
}
