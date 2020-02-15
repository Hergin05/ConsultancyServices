package com.consultancy.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.consultancy.model.Jobs;
import com.consultancy.model.User;

@Configuration
@ComponentScan("com.consultancy")
@EnableTransactionManagement  
public class ConfigurationDb 
{
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		System.out.println("Entering DataSource Bean creation method ");
		 BasicDataSource dataSource = new BasicDataSource();
		    dataSource.setDriverClassName("org.h2.Driver");
		    dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		    dataSource.setUsername("sa");
		    dataSource.setPassword("");
		    System.out.println("DataSource bean " +dataSource);
		    return dataSource;
	}
	
	@Bean(name="sessionFactory") 
	public SessionFactory sessionFactory() {
		System.out.println("Entering sessionFactory creation method");
		LocalSessionFactoryBuilder lsf= new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		
		Class classes[]=new Class[]{Jobs.class,User.class};
		
		System.out.println("SessionFactory bean " + lsf);
		return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	
	@Bean(name="TransactionManager")
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}

}
