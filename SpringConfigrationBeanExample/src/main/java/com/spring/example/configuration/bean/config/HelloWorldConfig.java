package com.spring.example.configuration.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.example.configuration.bean.vo.HelloWorld;

@Configuration
public class HelloWorldConfig 
{
	@Bean
	public HelloWorld helloWorldBean()
	{
		return new HelloWorld();
	}
	
	@Bean(name = "helloWorldBeanName")
	public HelloWorld helloWorld()
	{
		return new HelloWorld();
	}
}
