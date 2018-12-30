package com.spring.chapter2.createbeanjava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.spring.chapter2.createbeanjava.domain.AddHelloWorld;

public class SpringAutowiredConfig 
{
	@Autowired
	private SpringBeanConfig springBeanConfig;
	
	/* 메소드 이름이 아닌 다름 이름을 사용하고 싶다면
	 * name 속성을 사용하면 된다. 
	 * */
	@Bean(name = "addHelloWorldObj")
	public AddHelloWorld addHelloWorld()
	{
		return new AddHelloWorld(springBeanConfig.hello());
	}
}
