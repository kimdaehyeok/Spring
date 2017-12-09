package com.spring.chapter2.staticfactorymethod.dao;

public class FixedDepositStaticDaoFactory 
{

	public static FixDepositDao getFixDepositStiaticDao(String daoType)
	{
		return new FixDepositDao(daoType); 
	}
}
