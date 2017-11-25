package com.spring.chapter2.bankapp;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.chapter2.bankapp.controller.FixedDepositController;

public class BankApp
{
    private static Logger logger = Logger.getLogger(BankApp.class);
    
    public static void main(String[] args)
    {
        PropertyConfigurator.configure("src/main/resources/META-INF/log4j.properties");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/ApplicationContext.xml");
       
        FixedDepositController fixedDepositController = (FixedDepositController) context.getBean("controller");
        
        logger.info("Submission status of fixed deposit : " + fixedDepositController.submit());
        logger.info("Returned fixed deposit info : " + fixedDepositController.get());
    }
}
