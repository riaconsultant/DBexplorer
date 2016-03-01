package com.incture.automate;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestDto implements ParentDTO{

	private String dtoName;
	private int fieldCount;
	private List<FieldProperty> fieldProperty;

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

	public List<FieldProperty> getFieldProperty() {
		return fieldProperty;
	}

	public void setFieldProperty(List<FieldProperty> fieldProperty) {
		this.fieldProperty = fieldProperty;
	}

}
