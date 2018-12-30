package com.spring.example.autowired.AutowiredExample.domain;

import java.beans.ConstructorProperties;

import javax.management.ConstructorParameters;

public class SpellChecker 
{
	private String seperator;
	private String test1;
	private String test2;
	
	public SpellChecker(String seperator)
	{
		this.seperator = seperator;
	}
	
	public SpellChecker() 
	{
		System.out.println("Spell Check Constructor");
	}
	
	public void checkSpelling()
	{
		System.out.println("Inside Spelling");
	}
	
	public void whoAmI()
	{
		System.out.println("seperator : " + seperator);
	}
	
	public void testPrint()
	{
		System.out.println("test2 : " + test2);
		System.out.println("test1 : " + test1);
	}
}
