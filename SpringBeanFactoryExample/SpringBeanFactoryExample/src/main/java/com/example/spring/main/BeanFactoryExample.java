package com.example.spring.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import com.example.spring.provider.IMessageProvider;

/* Spring에서 IoC는 의존성 룩업(DL) 방식과 의존성 주입(DI) 방식 모두를 지원한다.
 * 가급적 스프링에서는 DI 방식을 사용하여 프로그램을 구현하는 것을 권장한다.
 * 단독 실행형 java 프로그램에서는 main() 에서 스프링 컨테이너를 DL로 처리해야 한다.
 * */

/* BeanFactory는 스프링 의존성 주입 컨테이너의 핵심이 되는 인터페이스 이다.
 * 의존성과 생명주기 등을 포함해 컴포넌트를 관리하는 책임을 진다.
 * 스프링에서 Bean은 컨테이너가 관리하는 컴포넌트를 가리킨다.
 * 
 * 어플리케이션은 BeanFactory 인터페이스를 구현하는 클래스 인스턴스를 생성하고 인스턴스에 빈과 의존성 설정 정보를 지정해야 한다.
 * 이렇게 하고 난 후 어플리케이션은 BeanFactory를 통해 Bean에 대한 접근이 가능하다. 
 * 
 * BeanFactory fac = new XmlBeanFactory(new FileInputStream("bean.xml")); 
 * MyBean myBean = (Mybean) factory.getBean("myBean"); 
 * */

/* ApplicationContext는 BeanFactory와 유사하지만 향상된 형태의 컨테이너 이다.
 * 
 * ListableBeanFactory(BeanFactory의 하위 인터페이스 이며, Bean을 Listable하게 보관하는 인터페이스로 대표적으로 DefaultListableBeanFactory 클래스)를 상속하고 있으며,
 * 여러가지 기능(ResourceLoader, ApplicationEventPublisher, MessageSource, Bean Lifecycle)을 추가로 제공한다.
 * 
 * 웹 어플리케이션에서는 web.xml 디스크립터 파일에 선언한 스프링 ContextLoaderListener 클래스에 의하여 어플리케이션이 시작 시점에 
 * 웹 컨테이너에 의해 스프링의 ApplicationContext가 자동으로 부트스트랩 된다
 * Context-Param에 의해 xml 들을 설정한다.
 * 
 * ContextListner : Spring Container로 Parent라 볼 수 있다.
 * DispatcherServlet에 의해 생성된 단일 혹은 다수의 SpringContainer가 Parent로 접근 할 수 있지만 역은 불가능하다.
 * DispatcherServlet에 의해 생성된 Bean은 ContextLoaderListener에 의해 생성된 Bean을 참조할 수 있다.
 * 
 * 참고 : https://gmlwjd9405.github.io/2018/10/29/web-application-structure.html
 * */

/* DefaultListableBeanFactory는 BeanFactory 인터페이스와 BeanDefinitionRegistry를 함께 구현하고 있으며
 * PropertiesBeanDefinitionReader나 XmlBeanDefinitionReader를 사용해 설정파일로 부터 Bean 설정 정보를 읽을 수 있다
 * */

public class BeanFactoryExample 
{
	public static void main(String[] args) 
	{
		//DefaultListableBeanFactory는 BeanFactory와 BeanDefinitionRegisty 인터페이스를 구현
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		
		// PropertiesBeanDefinitionReader나 XmlBeanDefinitionReader로 설정파일로 부터 Bean 설정 정보를 읽을 수 있다.
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory); 
		xmlBeanDefinitionReader.loadBeanDefinitions(new FileSystemResource("target/classes/com/example/spring/resources/xmlBeanFactory.xml"));

		/* PropertiesBeanDefinitionReader 예제
           PropertiesBeanDefinitionReader propDefReader = new PropertiesBeanDefinitionReader();
           propDefReader.loadBeanDefinitions(new FileSystemResource("src/main/resources/META-INF/spring/xmlBeanFactory.properties"));
         */
		
		IMessageProvider provider = (IMessageProvider) beanFactory.getBean("messageProvider");
		
		System.out.println(provider.getMessage());
	}
}
