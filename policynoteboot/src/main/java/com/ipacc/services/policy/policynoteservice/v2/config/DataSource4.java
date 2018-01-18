package com.ipacc.services.policy.policynoteservice.v2.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

@Configuration
@ConfigurationProperties(prefix="TGDBSERVER3DataSource")
public class DataSource4 {
	private DataSource datasource; // NOSONAR
	private String username;
	private String password;
	private String url;
	private String driverClass;
	private String poolName;
	private int maxActive;
	private int initialSize;
	private boolean testOnBorrow;
	private String validationQuery;
	
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getPoolName() {
		return poolName;
	}
	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}
	public int getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	public int getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}
	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public String getValidationQuery() {
		return validationQuery;
	}
	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
	public DataSource getDatasource() throws SQLException {
		PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
		pds.setURL(url);
		pds.setUser(username);
		pds.setPassword(password);
		pds.setConnectionFactoryClassName(driverClass);
		pds.setConnectionPoolName(poolName);		
		pds.setMaxPoolSize(maxActive);
		pds.setInitialPoolSize(initialSize);
		pds.setValidateConnectionOnBorrow(testOnBorrow);
		pds.setSQLForValidateConnection(validationQuery);

		return pds;
	}
}
