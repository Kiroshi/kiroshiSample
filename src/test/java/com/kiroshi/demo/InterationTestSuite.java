package com.kiroshi.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * junit will invokw the classes inside suiteclasses to run the tests in thos classes instead of running on junit
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	PersistenceSpringIntegrationTest.class,
	ServiceSpringIntegrationTest.class,
	WebSpringIntegrationTest.class
})
public class InterationTestSuite {

}
