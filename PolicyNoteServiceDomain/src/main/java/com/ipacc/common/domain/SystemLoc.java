package com.ipacc.common.domain;

public class SystemLoc {

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateAbbr() {
		return stateAbbr;
	}

	public void setStateAbbr(String stateAbbr) {
		this.stateAbbr = stateAbbr;
	}

	public String getSystemCategory() {
		return systemCategory;
	}

	public void setSystemCategory(String systemCategory) {
		this.systemCategory = systemCategory;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getArchiveOwnerName() {
		return archiveOwnerName;
	}

	public void setArchiveOwnerName(String archiveOwnerName) {
		this.archiveOwnerName = archiveOwnerName;
	}

	public String getOdbcConnectStr() {
		return odbcConnectStr;
	}

	public void setOdbcConnectStr(String odbcConnectStr) {
		this.odbcConnectStr = odbcConnectStr;
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getTableStructure() {
		return tableStructure;
	}

	public void setTableStructure(String tableStructure) {
		this.tableStructure = tableStructure;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String serverName, String env) {
		if (serverName != null && env != null) {
			if (serverName.trim().endsWith("1")) {
				db = "DB1";
			} else if (serverName.trim().endsWith("2")) {
				db = "DB2";
			} else if (serverName.trim().endsWith("3")) {
				db = "DB3";
			} else {
				db = "";
			}
		} else {
			db = "";
		}
	}

	protected String environment;
	protected int product;
	protected int state;
	protected String stateAbbr;
	protected String systemCategory;
	protected String serverName;
	protected String ownerName;
	protected String archiveOwnerName;
	protected String odbcConnectStr;
	protected String serverType;
	protected String tableStructure;
	protected String systemName;
	protected String db;
}
