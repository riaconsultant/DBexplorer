package com.automation.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestBeanDto {
	
	private String beanName;
	private RequestEntityDto requestentitydto;
	private RequestDto requestdto;
	private String persistentunit;

	public String getPersistentunit() {
		return persistentunit;
	}

	public void setPersistentunit(String persistentunit) {
		this.persistentunit = persistentunit;
	}

	public RequestEntityDto getRequestentitydto() {
		return requestentitydto;
	}

	public void setRequestentitydto(RequestEntityDto requestentitydto) {
		this.requestentitydto = requestentitydto;
	}

	public RequestDto getRequestdto() {
		return requestdto;
	}

	public void setRequestdto(RequestDto requestdto) {
		this.requestdto = requestdto;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

}
