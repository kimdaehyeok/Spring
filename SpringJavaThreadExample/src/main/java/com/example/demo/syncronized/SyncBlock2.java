package com.example.demo.syncronized;

import java.util.HashMap;

public class SyncBlock2 
{
	private HashMap<String, String> mMap1 = new HashMap<>();
	private HashMap<String, String> mMap2 = new HashMap<>();

	/* 4개의 메소드 안에 synchronized block은 동시에 호출될 수 없다.
	 * 어떤 스레드든 synchronized(this)에 접근 하는 순간 자원을 선점하고 lock을 걸어둔다.
	 * 
	 * */
	public static void main(String[] agrs) 
	{
		SyncBlock2 syncblock2 = new SyncBlock2();
	
		System.out.println("Test start!");
		
		new Thread(() -> {
			for (int i = 0; i < 10000; i++) 
			{
				syncblock2.put1("A", "B");
				syncblock2.get2("C");
			}
		}).start();
		new Thread(() -> 
		{
			for (int i = 0; i < 10000; i++) 
			{
				syncblock2.put2("C", "D");
				syncblock2.get1("A");
			}
		}).start();
		
		System.out.println("Test end!");
	}

	public void put1(String key, String value) 
	{
		synchronized (this) 
		{
			System.out.println("put1");
			mMap1.put(key, value);
		}
	}

	public String get1(String key) 
	{
		synchronized (this) 
		{
			System.out.println("get1");
			return mMap1.get(key);
		}
	}

	public void put2(String key, String value) 
	{
		synchronized (this) 
		{
			System.out.println("put2");
			mMap2.put(key, value);
		}
	}

	public String get2(String key) 
	{
		synchronized (this) 
		{
			System.out.println("get2");
			return mMap2.get(key);
		}
	}
}
