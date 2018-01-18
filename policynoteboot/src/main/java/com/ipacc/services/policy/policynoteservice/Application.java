package com.ipacc.services.policy.policynoteservice;


import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	/**
	 * Main execution method ... only called in embedded tomcat!
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Properties properties = System.getProperties(); 
		properties.put("org.apache.cxf.stax.allowInsecureParser", "1");
		System.setProperties(properties);
		SpringApplication.run(Application.class, args);
	}

	 /**
	  * Jboss specific method.  This is only used when the Jboss container starts...
	  * 
	  */
	 @Override
	 protected final SpringApplicationBuilder configure(final SpringApplicationBuilder applicationBuilder) {
		 return applicationBuilder.sources(Application.class);
	 }
}