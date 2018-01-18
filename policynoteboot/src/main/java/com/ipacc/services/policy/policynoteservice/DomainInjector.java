package com.ipacc.services.policy.policynoteservice;

import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipacc.policy.note.util.ContextFactory;
import com.ipacc.policy.note.util.ExternalBeanRegistrar;
import com.ipacc.services.policy.policynoteservice.v2.config.DataSource1;
import com.ipacc.services.policy.policynoteservice.v2.config.DataSource2;
import com.ipacc.services.policy.policynoteservice.v2.config.DataSource3;
import com.ipacc.services.policy.policynoteservice.v2.config.DataSource4;
import com.ipacc.services.policy.policynoteservice.v2.config.PropertiesDomainInjector;

@Component
public class DomainInjector {
	@Autowired
	DataSource1 dataSource1;
	
	@Autowired
	DataSource2 dataSource2;
	
	@Autowired
	DataSource3 dataSource3;
	
	@Autowired
	DataSource4 dataSource4;

	@Autowired 
	PropertiesDomainInjector propertiesDomainInjector;
	
	@PostConstruct
	public void injectDataSources() throws SQLException {
		// All classes should have some form of an ExternalBeanRegistrar.  We used this class to inject our datasources from the AMX Component to the domain jar.
		// Now we are using SpringBoot to inject the generated datasource instead!
		ExternalBeanRegistrar.setDB4(dataSource1.getDatasource());
		ExternalBeanRegistrar.setTGDBSERVER1DataSource(dataSource2.getDatasource());
		ExternalBeanRegistrar.setTGDBSERVER2DataSource(dataSource3.getDatasource());
		ExternalBeanRegistrar.setTGDBSERVER3DataSource(dataSource4.getDatasource());
		Properties properties = System.getProperties();
		properties.put("env", propertiesDomainInjector.getEnv());
		System.setProperties(properties);
		ContextFactory.init(properties);
		// Initialize the domain by injecting the Properties above!  READ BELOW! 
		// new InsuranceVerificationImpl(properties);
	    // The properties need to be injected into the domain somehow.  These properties that you set
		// will be referenced in the applicationConfig.xml files, for instance.
		// e.g.: if you see something like <property name="systemEnviron" value="${SystemEnviron}"/> in a spring xml file in the domain
		// set the property via the PropertiesDomainInjector by providing the value in the spring boot's application.yml file and then
		// instantiate your domain code by injecting the properties DOWN.  Note, you will most likely need to modify your domain code
		// to accept Propererties in it's constructors.  You can use the following code to set the properties.  Note this MUST be done
		// before initializing the DOMAIN CODE LOGICS APPLICATION CONTEXT!!!!
		// ---------------
		//	public InsuranceVerificationImpl(Properties parentProperties) {
		//      setPropertiesFromParent(parentProperties);
		//      context = SpringContext.getContext();
		//      verifyTGCoverage = (VerifyCoverage) context.getBean("verifyTGCoverage");
		//  }
		//
		//  private void setPropertiesFromParent(Properties parentProperties) {
		//      Properties childProperties = System.getProperties();
		//    	for (Entry<Object, Object> pp : parentProperties.entrySet()) {
        //		    childProperties.put(pp.getKey(), pp.getValue());
		//      }
		//   	System.setProperties(childProperties);
		//  }
		// ----------------

	}
}
