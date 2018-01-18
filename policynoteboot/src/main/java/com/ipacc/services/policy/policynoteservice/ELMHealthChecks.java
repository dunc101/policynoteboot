package com.ipacc.services.policy.policynoteservice;

import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.DataSourceHealthIndicator;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.ipacc.enterprise.elm.logging.HealthCheck;
import com.ipacc.enterprise.elm.logging.InfinityLogger;
import com.ipacc.enterprise.elm.logging.InfinityLoggerFactory;
import com.ipacc.services.policy.policynoteservice.v2.config.DataSource1;
import com.ipacc.services.policy.policynoteservice.v2.config.DataSource2;
import com.ipacc.services.policy.policynoteservice.v2.config.DataSource3;
import com.ipacc.services.policy.policynoteservice.v2.config.DataSource4;


/**
 * This is an example class that will automatically add health checks on startup
 * of the spring boot app.
 * 
 * @author DuncanDA
 *
 */
@Component
public class ELMHealthChecks {
	private static final String SELECT_1_FROM_DUAL = "SELECT 1 FROM DUAL";

	private static InfinityLogger log = InfinityLoggerFactory.getInstance(Application.class);

	private static final String DATASOURCE1_NAME = "db4";
	private static final String DATASOURCE2_NAME = "tgdb1";
	private static final String DATASOURCE3_NAME = "tgdb2";
	private static final String DATASOURCE4_NAME = "tgdb3";
	
	@Autowired
	DataSource1 dataSource1;
	
	@Autowired
	DataSource2 dataSource2;
	
	@Autowired
	DataSource3 dataSource3;
	
	@Autowired
	DataSource4 dataSource4;
	
	@Bean
	public HealthIndicator db4HealthIndicator() throws SQLException {
	    return new DataSourceHealthIndicator(dataSource1.getDatasource(), SELECT_1_FROM_DUAL);
	}
	
	@Bean
	public HealthIndicator tgDataSource1HealthIndicator() throws SQLException {
	    return new DataSourceHealthIndicator(dataSource2.getDatasource(), SELECT_1_FROM_DUAL);
	}
	
	@Bean
	public HealthIndicator tgDataSource2HealthIndicator() throws SQLException {
	    return new DataSourceHealthIndicator(dataSource3.getDatasource(), SELECT_1_FROM_DUAL);
	}
	
	@Bean
	public HealthIndicator tgDataSource3HealthIndicator() throws SQLException {
	    return new DataSourceHealthIndicator(dataSource4.getDatasource(), SELECT_1_FROM_DUAL);
	}
	/**
	 * Add ELM health checks. You should update this accordingly.
	 * 
	 * @return boolean true or false
	 * @throws Exception
	 */
	//@PostConstruct
	public boolean addHealthChecks() throws HealthCheckException {
		boolean status = false;
		try {
			log.debug("Adding health checks.");
			// add the datasource health checks
			HealthCheck healthCheck = new HealthCheck(log);
			healthCheck.monitorDatabase(DATASOURCE1_NAME, dataSource1.getDatasource());
			healthCheck.monitorDatabase(DATASOURCE2_NAME, dataSource2.getDatasource());
			healthCheck.monitorDatabase(DATASOURCE3_NAME, dataSource3.getDatasource());
			healthCheck.monitorDatabase(DATASOURCE4_NAME, dataSource4.getDatasource());
			status = true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new HealthCheckException(e.getMessage());
		}
		return status;
	}

	/**
	 * Exception class for HealthChecks
	 * 
	 * @author DuncanDA
	 *
	 */
	public class HealthCheckException extends Exception {
		private static final long serialVersionUID = 2457258802032852144L;
		/**
		 * Constructor for HealthCheckException with the reason
		 * 
		 * @param message
		 */
		public HealthCheckException(String message) {
			super(message);
		}
	}
}
