package com.incture.automate;

import com.automation.bean.CreateDoExample;

public class DOFormat implements Format{

	@Override
	public String draw(ParentDTO requestEntity) {
		System.out.println("Inside draw DOShape  ");
		CreateDoExample.createSrcEntity(requestEntity);
		return "";
	}

}
