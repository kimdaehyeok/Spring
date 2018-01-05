package com.spring.example.aop.transactional.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.example.aop.transactional.config.AppConfig;
import com.spring.example.aop.transactional.dao.OracleDAO;
import com.spring.example.aop.transactional.dao.OracleInterface;


public class MainClass 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    	/*CGLIB를 사용하는 경우.*/
    	OracleDAO oracleDAO = (OracleDAO) context.getBean("getOracleDAO");
    	JdbcTemplate oracleJdbcTemplate = (JdbcTemplate) context.getBean("getOracleJdbcTemplate");
    	oracleDAO.updateOracle("k2", oracleJdbcTemplate);
    	
    	/*Dynamic Proxy를 사용하는 경우.*/
//    	OracleInterface oracleDAO2 = (OracleInterface) context.getBean("getOracleDAO");
//    	JdbcTemplate oracleJdbcTemplate2 = (JdbcTemplate) context.getBean("getOracleJdbcTemplate");
//    	
//    	oracleDAO2.updateOracle("k3", oracleJdbcTemplate2);
    	
    }
}
