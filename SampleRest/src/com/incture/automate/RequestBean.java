package com.incture.automate;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestBean implements ParentDTO {

	private String beanName;
	private String restwrappername;
	private String path;
	private RequestEntity requestEntity;
	private RequestDto requestDto;
	private String persistentUnit;
	private List<MethodProperty> mProperty;

	public String getRestwrappername() {
		return restwrappername;
	}

	public void setRestwrappername(String restwrappername) {
		this.restwrappername = restwrappername;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

}
