package com.example.demo.syncronized;

public class BasicSynchronizedMethod {
	private String mHero;

	/* 두 스레드가 다른 메소드를 호출하고 있지만 객체에 lock이 걸리기 때문에
	 * 동시에 호출할 수 없다.
	 * 
	 * 즉 synchronized 함수에 의해 다른 모든 synchronized의 접근까지 lock이 걸린다.
	 * 이런 문제를 해결하기 위해 synchronized block이 존재한다.
	 * */
	public static void main(String[] args) 
	{
		BasicSynchronizedMethod temp = new BasicSynchronizedMethod();

		System.out.println("Test Start");

		new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				temp.batman();
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				temp.superman();
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				temp.noSynchronizedMethod();
			}
		}).start();

		System.out.println("Test end!");
	}

	public synchronized void batman() 
	{
		mHero = "batman";
		
		try 
		{
			long sleep = (long) (Math.random() * 100);
			Thread.sleep(sleep);
		
			if ("batman".equals(mHero) == false) 
			{
				System.out.println("synchronization broken");
			}
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	public synchronized void superman() 
	{
		mHero = "superman";
		
		try
		{
			long sleep = (long) (Math.random() * 100);
			Thread.sleep(sleep);
		
			if ("superman".equals(mHero) == false) 
			{
				System.out.println("synchronization broken");
			}
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	public void noSynchronizedMethod()
	{
		System.out.println("no synchronized method");
	}
}
