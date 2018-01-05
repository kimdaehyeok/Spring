package com.spring.example.aop.transactional.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/*  Spring에서는 Java Config 방식으로 트랜잭션을 구현할 수 있는데, 이를 위해 사용되는 어노테이션이 @EnableTransactionManagement 어노테이션이다.
 *  이 어노테이션을 사용하면 <tx:annotation-driven /> 태그를 사용하는 것과 동일한 설정을 하게 된다. 다만 차이점이 존재하는 부분이 있다.
 *  <tx:annotation-driven /> 태그의 경우는 해당 태그에 적용되는 Transaction Manager bean을 찾는 방법을 bean의 이름으로 찾게 된다.
 *  <tx:annotation-driven /> 태그에는 속성으로 transaction-Manager란 속성이 있는데 이 속성을 이용해서 사용하고자 하는 Transaction Manager bean 이름을 설정하게 된다.
 *  이 속성의 기본값은 transactionManager 로 되어 있어 Transaction Manager bean의 이름을 transactionManager로 설정하면 
 *  <tx:annotation-driven /> 태그에서 transactionManager 속성을 지정하지 않아도 이용이 가능하다. 
 *  그러나 @EnableTransactionManagement는 이러한 Transaction Manager bean을 찾는 방법을 bean의 타입으로 찾게 된다. 
 *  Spring에서 제공하는 Transaction Manager 클래스들은 PlatformTransactionManager 인터페이스를 구현하고 있는데
 *  @EnableTransactionManagement 어노테이션은 등록되어 있는 Spring Bean 들 중에서 PlatformTransactionManager 인터페이스를 구현한 클래스타입의 bean을 찾아서
 *  이를 Transaction Manager로 사용하게 된다. 즉 bean의 이름을 구애받지 않기 때문에 Transaction Manager bean의 이름을 어떤것을 사용하든(txManager, tm 등) 상관이 없다.*/

@Configuration
@EnableTransactionManagement
public class OracleDataAccessConfig //implements TransactionManagementConfigurer
{
	private static Logger logger = Logger.getLogger("OracleDataAccessConfig.class");
	
	private BasicDataSource oracleDataSource;
	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	private String databaseURL = "jdbc:oracle:thin:@10.40.1.26:1521:springdb";
	private String userName = "scott";
	private String password = "tiger";
	
	private DataSource dataSource()
	{
		oracleDataSource = new BasicDataSource();
		oracleDataSource.setDriverClassName(driverClassName);
		oracleDataSource.setUrl(databaseURL);
		oracleDataSource.setUsername(userName);
		oracleDataSource.setPassword(password);
		
		return oracleDataSource;
	}
	
	@Bean
	public JdbcTemplate getOracleJdbcTemplate()
	{
		JdbcTemplate oracleJdbcTemplate = new JdbcTemplate(dataSource());
		
		return oracleJdbcTemplate;
	}
	
//	@Override
//	@Bean
//	public PlatformTransactionManager annotationDrivenTransactionManager() {
//		// TODO Auto-generated method stub
//		return new DataSourceTransactionManager(dataSource());
//	}
	
//    인터페이스를 상속 받지 않는 경우.	
    @Bean
    public PlatformTransactionManager transactionManager() 
	{
        return new DataSourceTransactionManager(dataSource());
    }

}
