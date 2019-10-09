package com.example.demo.syncronized;

/* 자바 메모리 영역(Runtime Data Areas : JVM이 운영체제에 할당받은 메모리 영역)
 * 
 * 1. 힙 영역 
 *    - 데이터를 저장하기 위해 런타임 시 동적으로 사용되는 공간 
 *    - new 연산자로 생성된 객체 또는 배열을 저장하는 공간으로 모든 스레드에서 공유한다.
 *    - 쉽게 말해 Object 타입(Integer, String, ArrayList, ...)은 heap 영역에 생성된다.
 *    - 객체의 멤버변수는 그 타입이 기본형이든 참조형이든 상관없이 객체와 함께 힙에 저장된다.
 *    - 힙 영역의 Object는 Immutable의 성격을 가지고 있다. 즉 변경되는 연산이 수행되면 실제 메모리에서는 새로운 객체가 할당되는 것이다.
 *    
 * 2. 스택 영역
 *    - 메소드 정보, 지역변수, 매개변수, 연산 중 발생하는 임시 데이터를 저
 *    - 각 스레드마다 하나씩 존재한다. 즉 각 스레드는 자신만의 스택 영역을 갖는다.
 *    - 즉, 스레드 하나가 새롭게 생성되는 순간 해당 스레드를 위한 stack 도 함께 생성되며, 각 스레드에서 다른 스레드의 stack 영역에는 접근할 수 없다.
 *    - 힙 영역에 생성된 Object 타입의 데이터의 참조값 저장한다.
 *    - 또한 원시타입 byte, short, int, long, double, float, boolean, char 타입의 데이터들이 할당
 * 
 * 3. 클래스 영역(메소드 영역, 스태틱 영역, 코드 영)
 *    - 클래스 파일의 바이트 코드 및 상수 풀이 로딩된다.  
 *    - 전역변수(멤버변수, 필드) 이름, 데이터 타입, 접근 제어자에 대한 정보
 *    - 메소드의 이름, 리턴타입, 매개변수, 접근제어자의 대한 정보
 *    - 타입 속성(Class 인지 interface) 여부 저장
 *    - 상수, Static 변수(정적변수) 
 * */

/* https://yaboong.github.io/java/2018/05/26/java-memory-management/
 * https://programmers.co.kr/learn/courses/9
 * https://tourspace.tistory.com/54
 * https://everysw.tistory.com/entry/notifyAll-과-wait-사용시-주의점
 * https://parkcheolu.tistory.com/14
 * https://12bme.tistory.com/142
 * https://parkcheolu.tistory.com/14
 * */
public class TestMain 
{
	public static void main(String[] args) 
	{
	}
}
