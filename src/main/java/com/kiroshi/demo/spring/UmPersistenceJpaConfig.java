package com.kiroshi.demo.spring;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.kiroshi.demo.persistence") 
@PropertySource({"classpat:persistence-${persistenceTarget:h2}.properties"}) 
@EnableJpaRepositories(basePackages="com.kiroshi.persistence.dao")
public class UmPersistenceJpaConfig {

	@Autowired
	private Environment env;
	
	public UmPersistenceJpaConfig(){
		super();
	}
	
	//entity manager fact bean
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.kiroshi.demo" });
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(setAdditionalProperties());
        return em;
    }
	
	//set datasource
	@Bean
	public DataSource dataSource() {
		 final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	        dataSource.setUrl(env.getProperty("jdbc.url"));
	        dataSource.setUsername(env.getProperty("jdbc.username"));
	        dataSource.setPassword(env.getProperty("jdbc.password"));
	        return dataSource;
	}
	
	@Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
	
	//set add prop
	final Properties setAdditionalProperties() {
		final Properties additionalProperties = new Properties();
		additionalProperties.setProperty("hibernate.hbm2ddl", env.getProperty("hbm2ddlauto", "create-drop"));
		additionalProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		
		return additionalProperties; 
	}
	
}
