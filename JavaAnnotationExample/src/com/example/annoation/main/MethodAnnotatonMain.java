package com.example.annoation.main;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.example.annoation.custom.MethodAnnotation;
import com.example.annoation.custom.MethodSubAnnotation;

public class MethodAnnotatonMain 
{	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException 
	{
		Class<MethodAnnotatonMain> exampleClass = MethodAnnotatonMain.class;
		
		MethodAnnotation myAnnotation = null;
		
		Method[] methods = exampleClass.getDeclaredMethods();
		
		Annotation[] annotations;
		
		for(Method method : methods)
		{
			annotations = method.getAnnotations();
			
			System.out.println("Method Name : " + method.getName());
			System.out.println();
			
			for(Annotation annotation : annotations)
			{
				myAnnotation = (MethodAnnotation) annotation;
				
				System.out.println("value : " + myAnnotation.value());
				System.out.println("class : " + myAnnotation.myClass().toString());
				System.out.println("myEnum : " + myAnnotation.myEnum());
				System.out.println("sub : " + myAnnotation.mySubAnnotation().toString());
				
				System.out.println();

				MethodCallTestClass myClass = (MethodCallTestClass) myAnnotation.myClass().newInstance();
				myClass.runProcess();
				System.out.println();
			}
		}
	}
	
	@MethodAnnotation
	(
		value = "value_method1",
		myClass = MethodCallTestClass.class,
		myEnum = MethodAnnotation.MY_ENUM.MY_ENUM2,
		myStrings = {"String1","String2","String3"},
		mySubAnnotation = @MethodSubAnnotation(value1="value1", value2 ="value2")
	)
	public static void method1()
	{
		
	}
	
	@MethodAnnotation
	(
        value = "value",
        myClass=MethodCallTestClassExtend.class,
        myStrings = { "MyString1","MyString2","MyString3"},
        mySubAnnotation = @MethodSubAnnotation                                                    
     )

	@SuppressWarnings("fallthrough") // RetentionPolicy∞° SOURCE¿”
	public static void method2() 
	{

    }
}
