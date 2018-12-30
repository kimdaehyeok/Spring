package com.spring.example.aop.transactional.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.spring.example.aop.transactional.dao.OracleDAO;

@Configuration
@Import(OracleDataAccessConfig.class)
public class AppConfig 
{
	@Bean
	public OracleDAO getOracleDAO()
	{
		return new OracleDAO();
	}
}
