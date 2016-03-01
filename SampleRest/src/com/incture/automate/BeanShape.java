package com.incture.automate;

import com.automation.bean.CreateDoExample;

public class BeanShape implements Shape{

	@Override
	public String draw(ParentDTO requestBean) {
		CreateDoExample.createSrcBean(requestBean);
		return null;
	}

}
