package com.incture.automate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ParameterProperty {
	private String pName;
	private String pDataType;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDataType() {
		return pDataType;
	}

	public void setpDataType(String pDataType) {
		this.pDataType = pDataType;
	}

}
