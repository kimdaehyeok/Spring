package com.example.demo.notify;

/* if (money == 0) 실행결과
Withdraw. money : -2165460
Withdraw. money : -2165470
Withdraw. money : -2165480
Withdraw. money : -2165490
Withdraw. money : -2165500
Withdraw. money : -2165510
*/

/* money가 0 이면 consumer 스레드가 wait 상태가 된다.
 * producer 스레드가 moeny를 입금한 뒤 notifyAll()을 호출한다.
 * consumer wait 상태의 스레드가 wait()함수 다음부터 수행하여 0 이하의 숫자가 출력된다.
 * 
 * 그러므로 while을 통해 다시 체크 할 수 있도록 한다.
 * */

/* https://lalwr.blogspot.com/2018/03/thead-notify-notifyall-wait.html
 * */
public class ThreadBank 
{
	private int money = 0;

	ThreadBank(int money) 
	{
		this.money = money;
	}

	synchronized void withdraw(int value) 
	{
		try 
		{
			// if 문을 사용하여 현재 money 가 0 인지 확인한다.
//			if (money == 0)
//				wait(); // money 가 0이면 Lock 을 릴리즈하고 대기 상태에 빠진다.

            while(money == 0)
                wait(); // money 가 0이면 Lock 을 릴리즈하고 대기 상태에 빠진다.
            
			money -= value;

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Withdraw. money : " + money);

	}

	synchronized void deposit(int value) 
	{
		money += value;

		// wait 을 호출하여 대기 상태에 빠져 있는 모든 쓰레드들을 깨운다.
		notifyAll();

		System.out.println("Deposit. money : " + money);
	}
}

class Producer implements Runnable
{
	private ThreadBank mBalance;

	Producer(ThreadBank balance) {
		mBalance = balance;
	}

	@Override
	public void run() 
	{
		// 100번 루프를 돌면서 100씩 저금한다.
		for (int i = 0; i < 100; i++) 
		{
			System.out.println("### : " + i);
			mBalance.deposit(100);
		
			try
			{
//				Thread.sleep(1);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable 
{
	private ThreadBank mBalance;

	public Consumer(ThreadBank balance) 
	{
		mBalance = balance;
	}

	@Override
	public void run() 
	{
		while (true) 
		{
			// 무한 루프를 돌면서 10씩 인출한다.
			mBalance.withdraw(10);
		}
	}
}
