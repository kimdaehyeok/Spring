package com.spring.chapter2.staticfactorymethod.dao;

public class FixDepositDao implements FixDepositDaoInterface
{
	private String getDaoSeperator;
	
	public FixDepositDao(String getDaoSeperator)
	{
		this.getDaoSeperator = getDaoSeperator;
	}

	public void printWhoAmI() 
	{
		System.out.println("Fix Depost Dao : " + getDaoSeperator);
	}

}
