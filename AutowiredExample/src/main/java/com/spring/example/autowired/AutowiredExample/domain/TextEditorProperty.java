package com.spring.example.autowired.AutowiredExample.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditorProperty 
{
	   @Autowired(required=false)
	   @Qualifier("spellCheck1")
	   private SpellChecker spellCheck1;

	   @Autowired
	   @Qualifier("spellCheck2")
	   private SpellChecker spellCheck2;
	   
	   public TextEditorProperty() 
	   {
	      System.out.println("Inside TextEditor constructor." );
	   }
	   
	   public void spellCheckTest()
	   {
		   if(spellCheck1 != null)
		   {
			   System.out.println("spellCheck1 is not null");
			   spellCheck1.checkSpelling();
			   spellCheck1.whoAmI();
		   }
		   else
		   {
			   System.out.println("spellCheck1 is null");
			   spellCheck2.checkSpelling();
			   spellCheck2.whoAmI();
		   }
	   }
}
