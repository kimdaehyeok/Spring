package com.example.spring.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import com.example.spring.provider.IMessageProvider;

/* Spring���� IoC�� ������ ���(DL) ��İ� ������ ����(DI) ��� ��θ� �����Ѵ�.
 * ������ ������������ DI ����� ����Ͽ� ���α׷��� �����ϴ� ���� �����Ѵ�.
 * �ܵ� ������ java ���α׷������� main() ���� ������ �����̳ʸ� DL�� ó���ؾ� �Ѵ�.
 * */

/* BeanFactory�� ������ ������ ���� �����̳��� �ٽ��� �Ǵ� �������̽� �̴�.
 * �������� �����ֱ� ���� ������ ������Ʈ�� �����ϴ� å���� ����.
 * ���������� Bean�� �����̳ʰ� �����ϴ� ������Ʈ�� ����Ų��.
 * 
 * ���ø����̼��� BeanFactory �������̽��� �����ϴ� Ŭ���� �ν��Ͻ��� �����ϰ� �ν��Ͻ��� ��� ������ ���� ������ �����ؾ� �Ѵ�.
 * �̷��� �ϰ� �� �� ���ø����̼��� BeanFactory�� ���� Bean�� ���� ������ �����ϴ�. 
 * 
 * BeanFactory fac = new XmlBeanFactory(new FileInputStream("bean.xml")); 
 * MyBean myBean = (Mybean) factory.getBean("myBean"); 
 * */

/* ApplicationContext�� BeanFactory�� ���������� ���� ������ �����̳� �̴�.
 * 
 * ListableBeanFactory(BeanFactory�� ���� �������̽� �̸�, Bean�� Listable�ϰ� �����ϴ� �������̽��� ��ǥ������ DefaultListableBeanFactory Ŭ����)�� ����ϰ� ������,
 * �������� ���(ResourceLoader, ApplicationEventPublisher, MessageSource, Bean Lifecycle)�� �߰��� �����Ѵ�.
 * 
 * �� ���ø����̼ǿ����� web.xml ��ũ���� ���Ͽ� ������ ������ ContextLoaderListener Ŭ������ ���Ͽ� ���ø����̼��� ���� ������ 
 * �� �����̳ʿ� ���� �������� ApplicationContext�� �ڵ����� ��Ʈ��Ʈ�� �ȴ�
 * Context-Param�� ���� xml ���� �����Ѵ�.
 * 
 * ContextListner : Spring Container�� Parent�� �� �� �ִ�.
 * DispatcherServlet�� ���� ������ ���� Ȥ�� �ټ��� SpringContainer�� Parent�� ���� �� �� ������ ���� �Ұ����ϴ�.
 * DispatcherServlet�� ���� ������ Bean�� ContextLoaderListener�� ���� ������ Bean�� ������ �� �ִ�.
 * 
 * ���� : https://gmlwjd9405.github.io/2018/10/29/web-application-structure.html
 * */

/* DefaultListableBeanFactory�� BeanFactory �������̽��� BeanDefinitionRegistry�� �Բ� �����ϰ� ������
 * PropertiesBeanDefinitionReader�� XmlBeanDefinitionReader�� ����� �������Ϸ� ���� Bean ���� ������ ���� �� �ִ�
 * */

public class BeanFactoryExample 
{
	public static void main(String[] args) 
	{
		//DefaultListableBeanFactory�� BeanFactory�� BeanDefinitionRegisty �������̽��� ����
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		
		// PropertiesBeanDefinitionReader�� XmlBeanDefinitionReader�� �������Ϸ� ���� Bean ���� ������ ���� �� �ִ�.
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory); 
		xmlBeanDefinitionReader.loadBeanDefinitions(new FileSystemResource("target/classes/com/example/spring/resources/xmlBeanFactory.xml"));

		/* PropertiesBeanDefinitionReader ����
           PropertiesBeanDefinitionReader propDefReader = new PropertiesBeanDefinitionReader();
           propDefReader.loadBeanDefinitions(new FileSystemResource("src/main/resources/META-INF/spring/xmlBeanFactory.properties"));
         */
		
		IMessageProvider provider = (IMessageProvider) beanFactory.getBean("messageProvider");
		
		System.out.println(provider.getMessage());
	}
}
