package com.kiroshi.demo.spring;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.kiroshi.um.persistence") 
@PropertySource({"classpat:persistence-${persistenceTarget:h2}.properties"}) 
@EnableJpaRepositories(basePackages="com.kiroshi.persistence.dao")
public class UmPersistenceJpaConfig {

	@Autowired
	private Environment env;
	
	public UmPersistenceJpaConfig(){
		super();
	}
	
	
	final Properties setAdditionalProperties() {
		final Properties additionalProperties = new Properties();
		additionalProperties.setProperty("hibernate.hbm2ddl", env.getProperty("hbm2ddlauto", "create-drop"));
		additionalProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		
		return additionalProperties; 
	}
	
}
