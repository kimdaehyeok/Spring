package com.spring.test.SpringDIExample;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GetPersonObjByResourceScan 
{
   @Resource(name="Person")
   private Person personA;
   
   public void componentScanResourceAnnotationSampleMethod()
   {
       String name = personA.setName("kim daehyeok");
       int age = personA.setNumber(27);
       
       System.out.println("My name is " + personA.getName() + "! " + age + " years old");
   }
}
