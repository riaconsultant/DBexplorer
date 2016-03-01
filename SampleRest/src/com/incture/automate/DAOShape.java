package com.incture.automate;

import com.automation.bean.CreateDoExample;

public class DAOShape implements Shape {

	@Override
	public String draw(ParentDTO requestDao) {
		CreateDoExample.createSrcEntity(requestDao);
		return null;

	}

}
