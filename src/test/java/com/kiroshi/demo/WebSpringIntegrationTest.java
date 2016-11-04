package com.kiroshi.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kiroshi.demo.spring.UmContextConfig;
import com.kiroshi.demo.spring.UmPersistenceJpaConfig;
import com.kiroshi.demo.spring.UmServiceConfig;
import com.kiroshi.demo.spring.UmWebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UmPersistenceJpaConfig.class, UmContextConfig.class, UmServiceConfig.class, UmWebConfig.class })
public class WebSpringIntegrationTest {

	@Test
    public final void whenContextIsBootstrapped_thenOk() {
        //
    }
	
}
