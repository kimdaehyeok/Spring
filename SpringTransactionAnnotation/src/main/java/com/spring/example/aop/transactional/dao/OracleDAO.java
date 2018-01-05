package com.spring.example.aop.transactional.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class OracleDAO //implements OracleInterface
{
	@Transactional
	public void updateOracle(String job, JdbcTemplate oracleJdbcTemplate) {
		
		String query = "UPDATE SCOTT.EMP SET JOB = '" + job + " ' WHERE ENAME = 'BLAKE' ";

		oracleJdbcTemplate.update(query);
	}
}
