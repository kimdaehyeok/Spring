package com.spring.example.autowired.AutowiredExample.domain;

public class SpellChecker 
{
	private String seperator;
	
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
}
