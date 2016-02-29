package com.automation.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MainDto {
	
	private List<RequestDto> requestdto;
	private List<RequestEntityDto> requestentitydto;
	private List<RequestBeanDto> requestbean;
	
	public List<RequestBeanDto> getRequestBeandto() {
		return requestbean;
	}
	public void setRequestBeandto(List<RequestBeanDto> requestbean) {
		this.requestbean = requestbean;
	}
	public List<RequestDto> getRequestdto() {
		return requestdto;
	}
	public void setRequestdto(List<RequestDto> requestdto) {
		this.requestdto = requestdto;
	}
	public List<RequestEntityDto> getRequestentitydto() {
		return requestentitydto;
	}
	public void setRequestentitydto(List<RequestEntityDto> requestentitydto) {
		this.requestentitydto = requestentitydto;
	}
	

}
