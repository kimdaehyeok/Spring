package com.example.spring.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/* A bean post processor allows additional processing before and after the bean initialization callback method
 * Typically, bean post processors are used for checking the validity of bean properties or altering bean properties according to certain criteria.
 * 
 * To create a bean post processor class in spring:
 * 1. implement the BeanPostProcessor interface.
 * 2. implement postProcessBeforeInitialization() and postProcessAfterInitialization() methods.
 * 
 * Spring Bean Initialization Step
 * https://www.google.com/search?q=spring+bean+initialize&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiuiPn71b7fAhWDgLwKHftoDQwQ_AUIDigB&biw=1920&bih=969#imgrc=r0AZnsWMPX1PLM:
 * */
public class CustomBeanPostProcessor implements BeanPostProcessor
{
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException 
	{
		 System.out.println("Called postProcessBeforeInitialization() for :" + beanName);
	     return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException 
	{
        System.out.println("Called postProcessAfterInitialization() for :" + beanName);
        return bean;
	}
}
