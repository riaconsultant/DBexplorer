package com.incture.automate;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestEntity implements ParentDTO{

	private String entityName;
	private int fieldCount;
	private List<FieldProperty> fieldProperty;

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

	public List<FieldProperty> getFieldProperty() {
		return fieldProperty;
	}

	public void setFieldProperty(List<FieldProperty> fieldProperty) {
		this.fieldProperty = fieldProperty;
	}

}
