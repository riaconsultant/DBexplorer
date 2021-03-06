package com.incture.automate;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestBean implements ParentDTO {

	private String beanName;
	private String restWrapperName;
	private RequestEntity requestEntity;
	private RequestDto requestDto;
	private String persistentUnit;
	private List<MethodProperty> mProperty;
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRestWrapperName() {
		return restWrapperName;
	}

	public void setRestWrapperName(String restWrapperName) {
		this.restWrapperName = restWrapperName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public RequestEntity getRequestEntity() {
		return requestEntity;
	}

	public void setRequestEntity(RequestEntity requestEntity) {
		this.requestEntity = requestEntity;
	}

	public RequestDto getRequestDto() {
		return requestDto;
	}

	public void setRequestDto(RequestDto requestDto) {
		this.requestDto = requestDto;
	}

	public String getPersistentUnit() {
		return persistentUnit;
	}

	public void setPersistentUnit(String persistentUnit) {
		this.persistentUnit = persistentUnit;
	}

	public List<MethodProperty> getmProperty() {
		return mProperty;
	}

	public void setmProperty(List<MethodProperty> mProperty) {
		this.mProperty = mProperty;
	}

	@Override
	public String toString() {
		return "RequestBean [beanName=" + beanName + ", restWrapperName="
				+ restWrapperName + ", requestEntity=" + requestEntity
				+ ", requestDto=" + requestDto + ", persistentUnit="
				+ persistentUnit + ", mProperty=" + mProperty + ", path="
				+ path + "]";
	}

}
