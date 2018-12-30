package com.example.annoation.main;

public class MethodCallTestClass 
{
	public void runProcess()
    {
        System.out.println( "MyClass is running a process");
    }
}

class MethodCallTestClassExtend extends MethodCallTestClass 
{
	@Override
    public void runProcess() 
	{
        System.out.println( "MyClass2 is running a process");
    }
}