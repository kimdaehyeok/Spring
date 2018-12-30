package com.spring.example.autowired.AutowiredExample.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor 
{
	private SpellChecker spellChecker;

	public SpellChecker getSpellCheck2()
	{
		return spellChecker;
	}

	@Autowired
	@Qualifier("spellCheck2")
	public void setSpellCheck(SpellChecker spellChecker) 
	{
		this.spellChecker = spellChecker;
	}
	
	public void spellCheck()
	{
		spellChecker.whoAmI();
		spellChecker.checkSpelling();
	}
}
