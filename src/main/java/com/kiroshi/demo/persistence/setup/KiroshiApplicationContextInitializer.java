package com.kiroshi.demo.persistence.setup;

import org.slf4j.Logger;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class KiroshiApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
	
	
	public KiroshiApplicationContextInitializer(){
		super();
	}


	@Override
	public void initialize(final ConfigurableApplicationContext applicationContext) {
		final ConfigurableEnvironment environment = applicationContext.getEnvironment();
        final String activeProfiles = environment.getProperty("spring.profiles.active");
        logger.info("The active profiles are: {}", activeProfiles);

        environment.setActiveProfiles(activeProfiles.split(","));
	}
	
}
