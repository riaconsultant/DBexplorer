package com.incture.automate;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MethodProperty {

	private String name;
	private String returnType;
	private int noOfParamaeter;
	private List<ParameterProperty> pProperty;
	private String callType;
	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public int getNoOfParamaeter() {
		return noOfParamaeter;
	}

	public void setNoOfParamaeter(int noOfParamaeter) {
		this.noOfParamaeter = noOfParamaeter;
	}

	public List<ParameterProperty> getpProperty() {
		return pProperty;
	}

	public void setpProperty(List<ParameterProperty> pProperty) {
		this.pProperty = pProperty;
	}

}
