package com.incture.automate;

import com.automation.bean.CreateDoExample;

public class BeanFormat implements Format{

	@Override
	public String draw(ParentDTO requestBean) {
		CreateDoExample.createSrcBean(requestBean);
		return null;
	}

}
