package com.incture.automate;

import com.automation.bean.CreateDoExample;

public class DTOShape implements Shape{

	@Override
	public String draw(ParentDTO requestDto) {
		CreateDoExample.createSrcDto(requestDto);
		return null;
		
	}

}
