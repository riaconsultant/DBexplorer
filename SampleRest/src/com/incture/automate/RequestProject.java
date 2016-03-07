package com.incture.automate;

public class RequestProject {

	private String pName;
	private String pInfo;
	private String pVersion;
	private String pDomain;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpInfo() {
		return pInfo;
	}
	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}
	public String getpVersion() {
		return pVersion;
	}
	public void setpVersion(String pVersion) {
		this.pVersion = pVersion;
	}
	public String getpDomain() {
		return pDomain;
	}
	public void setpDomain(String pDomain) {
		this.pDomain = pDomain;
	}
	@Override
	public String toString() {
		return "RequestProject [pName=" + pName + ", pInfo=" + pInfo
				+ ", pVersion=" + pVersion + ", pDomain=" + pDomain + "]";
	}
	
}
