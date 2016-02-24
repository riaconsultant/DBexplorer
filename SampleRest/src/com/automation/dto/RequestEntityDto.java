package com.automation.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class RequestEntityDto {

	private String entityName;
	private int fieldCount;
	private List<FieldNameType> fieldTypeName;
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public int getFieldCount() {
		return fieldCount;
	}
	public void setFieldCount(int fieldCount) {
		this.fieldCount = fieldCount;
	}
	public List<FieldNameType> getFieldTypeName() {
		return fieldTypeName;
	}
	public void setFieldTypeName(List<FieldNameType> fieldTypeName) {
		this.fieldTypeName = fieldTypeName;
	}
	
}
