package com.example.annoation.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited  //부모 클래스에서 어노테이션을 상속받을 수 있다.
@Documented // 문서에도 어노테이션의 정보가 표시된다.
@Target({
	ElementType.TYPE
})
public @interface FieldAnnotation 
{
	public enum Quality {BAD, GOOD, VERYGOOD}
	
	public Quality quality() default Quality.GOOD;
	public String value1();
	public int[] value2();
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface StringInjector{
		public String value() default "This is StringInjector.";
		public int index = 3;
	}
	
	@Target(value = ElementType.METHOD)
	@Retention(value = RetentionPolicy.RUNTIME)
	public @interface CanRun {

	}
}
