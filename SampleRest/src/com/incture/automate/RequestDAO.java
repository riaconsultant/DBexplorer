package com.incture.automate;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestDAO implements ParentDTO {

	private String daoName;

	// private RequestEntity requestEntity;
	// private RequestDto requestDto;
	// private String persistentUnit;

	private List<MethodProperty> mProperty;

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}

	public List<MethodProperty> getmProperty() {
		return mProperty;
	}

	public void setmProperty(List<MethodProperty> mProperty) {
		this.mProperty = mProperty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((daoName == null) ? 0 : daoName.hashCode());
		result = prime * result
				+ ((mProperty == null) ? 0 : mProperty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestDAO other = (RequestDAO) obj;
		if (daoName == null) {
			if (other.daoName != null)
				return false;
		} else if (!daoName.equals(other.daoName))
			return false;
		if (mProperty == null) {
			if (other.mProperty != null)
				return false;
		} else if (!mProperty.equals(other.mProperty))
			return false;
		return true;
	}

}
