package com.ipacc.policy.note.util;

import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextFactory {

	private static ClassPathXmlApplicationContext context;

	public static void init(Properties properties) {
		setPropertiesFromParent(properties);
		getContext();
	}
	
	private static void setPropertiesFromParent(Properties parentProperties) {
	    Properties childProperties = System.getProperties();
	  	for (Entry<Object, Object> pp : parentProperties.entrySet()) {
    	    childProperties.put(pp.getKey(), pp.getValue());
	    }
	   	System.setProperties(childProperties);
	}
	
	public static ApplicationContext getContext() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("com/ipacc/policy/note/AppContext.xml");
		}
		return context;
	}

	public static void closeContext() {
		context.close();
		context = null;
	}

	static void registerShutdown() {
		context.registerShutdownHook();
	}

}
