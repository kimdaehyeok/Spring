package com.example.demo.syncronized;

import java.util.HashMap;

public class SyncBlock3 {
	private HashMap<String, String> mMap1 = new HashMap<>();
	private HashMap<String, String> mMap2 = new HashMap<>();
	
	private final Object object1 = new Object();
	private final Object object2 = new Object();

	/* lock을 걸 객체를 나눠서 지정하여 동시에 lock이 걸려야 할 부분만 선정할 수 있다.
	 * */
	public static void main(String[] agrs) 
	{
		SyncBlock3 syncblock3 = new SyncBlock3();
	
		System.out.println("Test start!");
		
		new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				syncblock3.put1("A", "B");
				syncblock3.get2("C");
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				syncblock3.put2("C", "D");
				syncblock3.get1("A");
			}
		}).start();
		
		System.out.println("Test end!");
	}

	public void put1(String key, String value) 
	{
		synchronized (object1) 
		{
			mMap1.put(key, value);
		}
	}

	public String get1(String key) 
	{
		synchronized (object1) 
		{
			return mMap1.get(key);
		}
	}

	public void put2(String key, String value) 
	{
		synchronized (object2) 
		{
			mMap2.put(key, value);
		}
	}

	public String get2(String key) 
	{
		synchronized (object2) 
		{
			return mMap2.get(key);
		}
	}
}
