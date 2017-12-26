package com.spring.example.spel.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.spring.example.spel.domain.DatabaseUser;

public class MainClass 
{
    public static void main( String[] args )
    {
        ExpressionParser parser = new SpelExpressionParser();
        
        Expression exp = parser.parseExpression("'Hello SPEL'");
        String message = (String) exp.getValue();
        System.out.println(message);
        System.out.println("--------------------------");
        
        Expression concatExp = parser.parseExpression("'Welcom SPEL'.concat('!')");
        String concatMessage = (String) concatExp.getValue();
        System.out.println(concatMessage);
        System.out.println("--------------------------");
        
        Expression byteLenghtExp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) byteLenghtExp.getValue();
        System.out.println(length);
        System.out.println("--------------------------");
        
        Expression upperExp = parser.parseExpression("new String('hello world').toUpperCase()");  
        String upperMessage = upperExp.getValue(String.class);  
        System.out.println(upperMessage);  
        System.out.println("--------------------------");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DatabaseUser dbUser = (DatabaseUser) context.getBean("databaseUser");
        dbUser.show();
    }
}
