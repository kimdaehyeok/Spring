package com.spring.chapter2.createbeanjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.chapter2.createbeanjava.domain.HelloWorld;

/* @Configuration
 * 클래스에 @Configuration을 지정하면 클래스에 @Bean 어노테이션이 지정된 메소드가 포함되어 있고 
 * 해당 메소드는 스프링 컨테이너에 등록되는 빈 인스턴스를 반환한다는 의미이다.
 * */

@Configuration 
public class SpringBeanConfig 
{
	/* 메소드명은 XML Bean id와 동일하다.
	 * 리턴되는 객체의 클래스가 XML Bean Class와 동일하다.(함수 리턴값이 아님을 주의)
	 * */
	@Bean
	public HelloWorld hello()
	{
		return new HelloWorld("normal bean");
	}
}
