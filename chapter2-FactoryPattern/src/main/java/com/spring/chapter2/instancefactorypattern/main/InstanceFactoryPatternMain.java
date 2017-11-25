package com.spring.chapter2.instancefactorypattern.main;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.chapter2.instancefactorypattern.dao.DaoObject;

public class InstanceFactoryPatternMain
{
    public static void main(String[] args)
    {
        PropertyConfigurator.configure("src/main/resources/META-INF/log4j.properties");
        
        ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:META-INF/spring/ApplicationContext.xml");
        
        // ApplicationContext의 constructor-arg의 값을 DaoObejctA,DaoObejctB로 변경하면서 테스트 수행.
        DaoObject dao = (DaoObject) context.getBean("dao");
        
        dao.printWhoAmI();
    }
}
