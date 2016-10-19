package com.kiroshi.demo.run;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

import com.kiroshi.demo.spring.UmContextConfig;
import com.kiroshi.demo.spring.UmPersistenceJpaConfig;
import com.kiroshi.demo.spring.UmServiceConfig;
import com.kiroshi.demo.spring.UmWebConfig;

@SpringBootApplication
@Import({
	UmContextConfig.class,
	UmPersistenceJpaConfig.class,
	UmServiceConfig.class,
	UmWebConfig.class
})
public class UmApp extends SpringBootServletInitializer {

	@Bean
	public DispatcherServlet dispatcherServlet(){
		return new DispatcherServlet();
	}
	
	/*replacement for web.xml*/
	@Bean
	public ServletRegistrationBean dispatcherServletRegistration(){
		final ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet(), "/asig/*");
		
		final Map<String, String> params = new HashMap<String ,String>();
		params.put("contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
		params.put("contextConfigLocation", "org.spring.sec2.spring");
		params.put("dispatchOptionsRequest", "true");
		
		servletRegistrationBean.setLoadOnStartup(1); 
		return servletRegistrationBean;
	}
	
	/*This pulls in all config classes through UmApp class*/
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder app) {
		return app.sources(UmApp.class);
	}
	
	/*main fct to actually run the app*/
	public static void main(String... args) {
		SpringApplication.run(UmApp.class, args);
	}
	
}
