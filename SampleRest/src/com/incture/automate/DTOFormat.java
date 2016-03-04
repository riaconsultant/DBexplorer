package com.incture.automate;

import com.automation.bean.CreateDoExample;

public class DTOFormat implements Format{

	@Override
	public String draw(ParentDTO requestDto) {
		CreateDoExample.createSrcDto(requestDto);
		return null;
		
	}

}
