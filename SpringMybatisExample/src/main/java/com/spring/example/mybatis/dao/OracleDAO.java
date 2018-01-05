package com.spring.example.mybatis.dao;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("oracleDAO")
public class OracleDAO 
{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static Logger logger = Logger.getLogger(OracleDAO.class);
	
	@Transactional
	public void updateJob(String job)
	{
		sqlSession.update("jobUpdate", job);
	}
}
