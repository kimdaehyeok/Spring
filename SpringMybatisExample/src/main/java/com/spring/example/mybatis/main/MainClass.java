package com.spring.example.mybatis.main;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.example.mybatis.dao.OracleDAO;

public class MainClass 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	
    	OracleDAO oracleDAO = (OracleDAO) context.getBean("oracleDAO");
    	oracleDAO.updateJob("MyJob");
    }
}
