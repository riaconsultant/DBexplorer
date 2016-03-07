package com.incture.automate;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClientRequestDto {

	private RequestProject reqProject;
	private List<RequestDto> requestDto;
	private List<RequestEntity> requestEntity;
	private List<RequestBean> requestBean;

	

	public RequestProject getReqProject() {
		return reqProject;
	}

	public void setReqProject(RequestProject reqProject) {
		this.reqProject = reqProject;
	}

	public List<RequestDto> getRequestDto() {
		return requestDto;
	}

	public void setRequestDto(List<RequestDto> requestDto) {
		this.requestDto = requestDto;
	}

	public List<RequestEntity> getRequestEntity() {
		return requestEntity;
	}

	public void setRequestEntity(List<RequestEntity> requestEntity) {
		this.requestEntity = requestEntity;
	}

	public List<RequestBean> getRequestBean() {
		return requestBean;
	}

	public void setRequestBean(List<RequestBean> requestBean) {
		this.requestBean = requestBean;
	}

	@Override
	public String toString() {
		return "ClientRequestDto [reqProject=" + reqProject + ", requestDto="
				+ requestDto + ", requestEntity=" + requestEntity
				+ ", requestBean=" + requestBean + "]";
	}

}
