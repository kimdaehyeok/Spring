package com.spring.example.importannotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SuperConfig.class)
public class ImportConfig 
{
	@Bean
	public String world()
	{
		return "world";
	}
	
	@Bean
	public String hello()
	{
		return "hello_original";
	}
}
