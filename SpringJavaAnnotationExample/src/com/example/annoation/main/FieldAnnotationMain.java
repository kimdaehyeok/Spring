package com.example.annoation.main;

import com.example.annoation.object.FieldAnnotationObject;

public class FieldAnnotationMain {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		// ���ؽ�Ʈ �����̳ʸ� �ʱ�ȭ �մϴ�.
		FieldContextContainer demo = new FieldContextContainer();

		// MyOjbect ��ü�� �ϳ� �޾ƿɴϴ�.
		FieldAnnotationObject obj = demo.getInstance(FieldAnnotationObject.class);

		System.out.println(obj.getName()); // print is "My name is JDM."
		System.out.println(obj.getDefaultName()); // print is "This is StringInjector."
		System.out.println(obj.getInvalidType()); // print is "null".
		
	}
}
