package com.ipacc.services.policy.policynoteservice.v2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="propertiesDomainInjector")
public class PropertiesDomainInjector {
	// Use this class to initialize the properties that are used in your Domain jar! @See DomainInjector.java for more info.  Also see the application.yml file for
	// an example.  More than likley you will not have a property named ${SystemEnviron} referenced in your
	// applicationContext.xml file in your domain code....Remove the property below as it was just used as an example!
	private String env; // NOSONAR

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}
}