package com.example.annoation.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation 
{
	public enum MY_ENUM{MY_ENUM1, MY_ENUM2, MY_ENUM3, MY_ENUM4};
	public String value();
	public Class<?> myClass() default Void.class;
	public MY_ENUM myEnum() default MY_ENUM.MY_ENUM1;
	public String[] myStrings();
	public MethodSubAnnotation mySubAnnotation();
}	
