package com.example.demo.method.join;

/* https://eskeptor.tistory.com/79?category=928923
 * */
public class TestMain 
{
	public static void main(String[] args) throws InterruptedException 
	{
		CalcThread calcThread = new CalcThread(5, 7);
		
		/* calcThread가 run을 호출하기 전에 getResult()를 출력하고 메인이 종료된다.*/
		calcThread.start();
		
		/* 이에따라 해당 메소드가 종료되기를 기다리는 join() 메소드를 사용한다. */
		calcThread.join();
		
		System.out.println(calcThread.getResult());
	}
}