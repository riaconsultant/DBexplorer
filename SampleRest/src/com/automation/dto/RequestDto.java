package com.automation.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class RequestDto {

	private String dtoName;
	private int fieldCount;
	private List<FieldNameType> fieldTypeName;
	
	public List<FieldNameType> getFieldTypeName() {
		return fieldTypeName;
	}

	public void setFieldTypeName(List<FieldNameType> fieldTypeName) {
		this.fieldTypeName = fieldTypeName;
	}

	public int getFieldCount() {
		return fieldCount;
	}

	public void setFieldCount(int fieldCount) {
		this.fieldCount = fieldCount;
	}

	public String getDtoName() {
		return dtoName;
	}

	public void setDtoName(String dtoName) {
		this.dtoName = dtoName;
	}

	

}
