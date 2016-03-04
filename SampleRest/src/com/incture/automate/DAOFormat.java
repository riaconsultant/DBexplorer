package com.incture.automate;

import com.automation.bean.CreateDoExample;

public class DAOFormat implements Format {

	@Override
	public String draw(ParentDTO requestDao) {
		CreateDoExample.createSrcDAO(requestDao);
		return null;

	}

}
