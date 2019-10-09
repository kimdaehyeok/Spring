package com.example.demo.thread;

public class FruitThread extends Thread 
{
	private String name;
	
	public FruitThread(String name)
	{
		this.name = name;
	}
	
	/* run()을 오버라이드 하며 여기에 실행될 코드를 입력한다.*/
	@Override
	public void run() 
	{
//		System.out.println(Thread.currentThread().getName());
		
		for(int i = 0; i < 5; i ++)
		{
			System.out.println("Thread Name : " + name + "쓰레드 입니다.");
			try
			{
				sleep(150);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/* run과 start의 차이점
	 * 
	 * 직접 run을 호출하게 되면 단순하게 메소드만 실행된다.
	 * 그러나 start를 호출하게 되면 쓰레드를 생성하여 run을 실행하게 해준다.
	 * 
	 * start()는 두번 이상 호출이 불가능하나(illegalStateException) run()은 가능하다.
	 * 
	 * start()는 java.lang.Thread.class에 선언되어 있으나
	 * run()은 java.lang.Runnable interface에 선언되어 있다.
	 * 
	 * http://developer.classpath.org/doc/java/lang/Thread-source.html
	 * https://www.geeksforgeeks.org/difference-between-thread-start-and-thread-run-in-java/
	 * */
	public static void main(String[] args) 
	{
		FruitThread apple = new FruitThread("Apple");
		FruitThread banana = new FruitThread("Banana");
		
		apple.run();
		banana.start();
	}
}
