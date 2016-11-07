package com.kiroshi.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.kiroshi.demo.model") 
@EnableAspectJAutoProxy(proxyTargetClass=true)
//@PropertySource({"classpath:settings.properties"})
public class UmContextConfig {

	public UmContextConfig(){
		super();
	}
	
	//beans
	
	//this method will be used without using an object as it belongs to the class rather than the object of the calss
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties(){
		PropertySourcesPlaceholderConfigurer prop = new PropertySourcesPlaceholderConfigurer();
		return prop;
	}
	
}
