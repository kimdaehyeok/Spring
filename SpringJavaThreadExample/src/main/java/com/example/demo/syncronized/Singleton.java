package com.example.demo.syncronized;

import java.util.ArrayList;

/* Singleton 객체에 synchronized를 사용하게 되면 스레드의 병목 현상을 야기 시킬 수 있다.
 * multi-thread 환경에서는 공유해야 할 객체가 아니라면 new를 이용하여 사용하는 것이 좋다.
 * */
public class Singleton 
{
	public ArrayList<Integer> mList = new ArrayList<>();

	private Singleton() 
	{
	}

	private static class Holder 
	{
		public static final Singleton sHolderSingleton = new Singleton();
	}

	public static Singleton getInstance() 
	{
		return Holder.sHolderSingleton;
	}

	public static void main(String[] agrs) throws InterruptedException 
	{
		System.out.println("Test start!");
		
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				Singleton.getInstance().add(i);
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				Singleton.getInstance().add(i);
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(Singleton.getInstance().mList.size());
		System.out.println("Test end!");
	}

	public synchronized void add(int val) 
	{
		if (mList.contains(val) == false) 
		{
			mList.add(val);
		}
	}

}
