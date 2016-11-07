package com.kiroshi.demo.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.kiroshi.demo.service") 
public class UmServiceConfig {

	public UmServiceConfig(){
		super();
	}
	
	//beans to be added
	
}
