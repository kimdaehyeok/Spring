package com.spring.example.autowired.AutowiredExample.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.example.autowired.AutowiredExample.domain.SpellChecker;
import com.spring.example.autowired.AutowiredExample.domain.TextEditor;
import com.spring.example.autowired.AutowiredExample.domain.TextEditorProperty;

public class MainClass {
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();
		System.out.println();

		TextEditorProperty textEditorProperty = (TextEditorProperty) context.getBean("textEditorProperty");
		textEditorProperty.spellCheckTest();
		System.out.println();

		SpellChecker sp = (SpellChecker) context.getBean("constructorName");
		sp.testPrint();
		// A a=context.getBean("a",A.class);
		// a.display();
	}
}
