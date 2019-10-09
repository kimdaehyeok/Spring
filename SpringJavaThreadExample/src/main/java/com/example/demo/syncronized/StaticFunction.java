package com.example.demo.syncronized;

public class StaticFunction 
{
	private static String HERO;

	/* static 함수의 경우 해당 class에 lock을 건다.
	 * */
	
	/* static의 경우 해당 class에 lock을 걸지만
	 * 일반 synchronized 함수를 혼합하여 사용하면 해당 객체에 lock을 걸기 때문에
	 * 동기화가 깨진다.
	 * */
	public static void main(String[] agrs) 
	{
		System.out.println("Test start!");
	
		new Thread(() -> {
			for (int i = 0; i < 10000; i++) 
			{
				/* static 함수 호출 */
				StaticFunction.batman();
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 10000; i++) 
			{
				/* static 함수 호출 */
				StaticFunction.superman();
			}
		}).start();
		
		StaticFunction sfunction = new StaticFunction();

		new Thread(() -> {
			for (int i = 0; i < 10000; i++) 
			{
				sfunction.ironman();
			}
		}).start();

	}

	public static synchronized void batman() 
	{
		HERO = "batman";
		
		try 
		{
			long sleep = (long) (Math.random() * 100);
			Thread.sleep(sleep);
		
			if ("batman".equals(HERO) == false) 
			{
				System.out.println("synchronization broken - batman");
			}
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	public static synchronized void superman() 
	{
		HERO = "superman";
		try 
		{
			long sleep = (long) (Math.random() * 100);
			Thread.sleep(sleep);
			if ("superman".equals(HERO) == false) 
			{
				System.out.println("synchronization broken - superman");
			}
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public synchronized void ironman() 
	{
		HERO = "ironman";
		
		try 
		{
			long sleep = (long) (Math.random() * 100);

			Thread.sleep(sleep);
		
			if ("ironman".equals(HERO) == false) 
			{
				System.out.println("synchronization broken - ironman");
			}
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
