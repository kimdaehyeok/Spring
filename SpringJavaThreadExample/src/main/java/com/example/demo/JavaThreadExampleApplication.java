package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* https://eskeptor.tistory.com/78?category=928923
 * */

/* 프로세스 : 프로그램이 메모리에 올라와 있는 상태를 말하며, 프로그램은 루틴이라 불리는 반복되는 실행코드를 가지고 있다.
 * 한번에 2개 이상의 흐름으로 프로그램을 진행하고 싶을 때, 쓰레드를 사용한다.
 * 
 * 즉 쓰레드란 프로세스에서 프로그램의 흐름을 형성하는 것이라고 할 수 있다. 
 * 그래서 2개 이상의 쓰레드를 사용하는 프로그램을 멀티 쓰레드 프로그램이라고 한다.
 * 
 * 쓰레드는 CPU Core를 공유하기 때문에, 1개의 CPU로 여러개의 쓰레드를 실행 할 수 있다.
 * */
@SpringBootApplication
public class JavaThreadExampleApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(JavaThreadExampleApplication.class, args);
	}
}
