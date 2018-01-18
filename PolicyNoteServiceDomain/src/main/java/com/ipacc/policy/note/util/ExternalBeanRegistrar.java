package com.ipacc.policy.note.util;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ExternalBeanRegistrar implements BeanFactoryPostProcessor {

	private static DataSource TGDBSERVER1DataSource = null;
	private static DataSource TGDBSERVER2DataSource = null;
	private static DataSource TGDBSERVER3DataSource = null;
	private static DataSource DB4 = null;

	public static void setTGDBSERVER1DataSource(DataSource ds) {
		TGDBSERVER1DataSource = ds;
	}

	public static void setTGDBSERVER2DataSource(DataSource ds) {
		TGDBSERVER2DataSource = ds;
	}

	public static void setTGDBSERVER3DataSource(DataSource ds) {
		TGDBSERVER3DataSource = ds;
	}

	public static void setDB4(DataSource ds) {
		DB4 = ds;
	}

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		if (TGDBSERVER1DataSource != null) {
			beanFactory.registerSingleton("TGDBSERVER1DataSource", TGDBSERVER1DataSource);
		}
		if (TGDBSERVER2DataSource != null) {
			beanFactory.registerSingleton("TGDBSERVER2DataSource", TGDBSERVER2DataSource);
		}
		if (TGDBSERVER3DataSource != null) {
			beanFactory.registerSingleton("TGDBSERVER3DataSource", TGDBSERVER3DataSource);
		}
		if (DB4 != null) {
			beanFactory.registerSingleton("DB4", DB4);
		}
	}

}