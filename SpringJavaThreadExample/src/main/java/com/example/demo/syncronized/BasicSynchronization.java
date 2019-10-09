package com.example.demo.syncronized;

public class BasicSynchronization 
{
	private String mMessage;

	public static void main(String[] args) throws InterruptedException 
	{
		BasicSynchronization temp = new BasicSynchronization();

		System.out.println("Test Start");

		new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				temp.callMe("Thread1");
			}
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				temp.callMe("Thread2");
			}
		}).start();
	}

	/* synchronized는 두가지 형태로 이용이 가능하다.
	 * 
	 * 1. synchronized 함수를 만들어 사용한다.
	 * 2. synchronized block을 사용한다.
	 * */
	
	/* 함수에 synchronized를 사용하면 그 함수가 포함된 객체(this)에 lock을 거는 것과 같다.
	 * */
	public void callMe(String whoCallMe) 
	{
		mMessage = whoCallMe;
		try 
		{
			long sleep = (long) (Math.random() * 100);
			Thread.sleep(sleep);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		if (!mMessage.equals(whoCallMe)) 
		{
			System.out.println(whoCallMe + " | " + mMessage);
		}
	}

}
