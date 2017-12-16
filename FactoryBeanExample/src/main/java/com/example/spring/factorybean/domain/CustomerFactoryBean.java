package com.example.spring.factorybean.domain;

import org.springframework.beans.factory.FactoryBean;

public class CustomerFactoryBean implements FactoryBean<MyBean> {
	
	private MyBean myBean;
	private String initString;
	
	public MyBean getMyBean() 
	{
		return myBean;
	}

	public void setMyBean(MyBean myBean)
	{
		this.myBean = myBean;
	}

	public String getInitString() 
	{
		return initString;
	}

	public void setInitString(String initString)
	{
		this.initString = initString;
	}

	@Override
	public MyBean getObject() throws Exception 
	{
		System.out.println("inside getObject");
		
		myBean = new MyBean(initString);
		return myBean;
	}

	@Override
	public Class<? extends MyBean> getObjectType() 
	{
		System.out.println("inside getObjectType");
		
		return myBean.getClass();
	}

	@Override
	public boolean isSingleton() 
	{
		System.out.println("inside isSingleton");
		
		return false;
	}

}
