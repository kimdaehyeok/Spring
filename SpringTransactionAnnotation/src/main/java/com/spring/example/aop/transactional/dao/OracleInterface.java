package com.spring.example.aop.transactional.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OracleInterface 
{
	public void updateOracle(String job, JdbcTemplate oracleJdbcTemplate);
}
