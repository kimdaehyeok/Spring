package com.example.demo.notify;

public class TestMain {
	public static void main(String[] args) {

		ThreadBank bank = new ThreadBank(0);

		Producer producer = new Producer(bank);
		Consumer consumer = new Consumer(bank);

		// Producer 쓰레드는 1개, Consumer 쓰레드는 10개를 만들어서 시작시킨다.
		new Thread(producer).start();

		for (int i = 0; i < 10; i++) {
			new Thread(consumer).start();
		}
	}
}
