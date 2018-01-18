package com.ipacc.policy.note.domain;

public abstract class DataObject {
	protected String policyID = null;
	protected int version;
	protected String serverName = "";
	protected String ownerName = "";

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

	public String getPolicyID() {
		return policyID;
	}

	public void setPolicyID(String policyID) {
		this.policyID = policyID;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
