package com.example.spring.factorybean.main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring.factorybean.domain.CustomerFactoryBean;
import com.example.spring.factorybean.domain.MyBean;

public class SpringFactoryBeanMain 
{
	private static Logger logger = Logger.getLogger(SpringFactoryBeanMain.class);
	
	public static void main(String[] args) throws Exception 
	{
		PropertyConfigurator.configure("src/main/resources/META-INF/log4j.properties");
		
		System.out.println("...Loading beans...");
		System.out.println();
		
		AbstractApplicationContext  context = new ClassPathXmlApplicationContext("Beans.xml");
		System.out.println();
		
		System.out.println("...fetch MyBean to get Object....");
		System.out.println();
		
		MyBean myBean=(MyBean) context.getBean("factoryBean"); // FactoryBean 인터페이스의 구현체가 아닌 FactoryBean.getObjec()에서 리턴되는 객체가 리턴
		CustomerFactoryBean myFactoryBean = (CustomerFactoryBean) context.getBean("&factoryBean"); // 수행시 FactoryBean 자체가 리턴된다. (id 앞에 &를 붙인다)
		
//		CustomerFactoryBean myBean= (CustomerFactoryBean)context.getBean(CustomerFactoryBean.class);
		
		System.out.println();
		System.out.print("Get Factory : ");
		myFactoryBean.getObject().doTask();
		System.out.println();
		
		myBean.doTask();
	}
}
