package com.automation.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.regex.Matcher;

import com.automation.dto.RequestBeanDto;
import com.automation.util.*;
import com.incture.automate.ParentDTO;
import com.incture.automate.RequestBean;

public class CreateJavaLayerLogic {

	public void createClass(int fileType, String className,
			Map<String, Class<?>> fields, Map<String, String> customfields)
			throws IOException {
		CommonUtil commonUtil = new CommonUtil();
		String packageName = "";
		StringBuilder builder = new StringBuilder();
		if (fileType == 1) {
			packageName = LocalConstant.PACKAGE_DTO;
		} else if (fileType == 2) {
			packageName = LocalConstant.PACKAGE_DO;
		}
		if (packageName != null)
			builder.append("package ").append(packageName).append(";\n");
		builder = commonUtil.startClassCreation(fileType,builder, className, fields,
				customfields);
		if (fileType == 2) {
			builder = commonUtil.getEntityTags(builder, className);
		} else if (fileType == 1) {
			builder.append("public class ").append(className).append("\n");
			builder.append("{\n");
		}

		builder = commonUtil.getPojoClass(fileType, builder, fields,
				customfields);
		// builder =
		// commonutil.getCustomPojoClass(FileType,builder,customfields);

		builder.append("}\n");
		//builder.append("}\n");
		File dir = new File(packageName.replaceAll("\\.",
				Matcher.quoteReplacement(System.getProperty("file.separator"))));
		System.err.println("path--" + dir.getAbsolutePath());

		dir.mkdirs();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(dir, className + ".java"))));

		writer.write(builder.toString());
		writer.close();
	}

	public void createBeanClass(ParentDTO dto) throws IOException {
		CommonUtil commonutil = new CommonUtil();
		String packageName = LocalConstant.PACKAGE_BEAN;
		StringBuilder builder = new StringBuilder();
		builder.append("package ").append(packageName).append(";\n");
		builder = commonutil.startBeanClassCreation(builder, dto);
		File dir = new File(packageName.replaceAll("\\.",
				Matcher.quoteReplacement(System.getProperty("file.separator"))));
		System.err.println("path--" + dir.getAbsolutePath());
		dir.mkdirs();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(dir, ((RequestBean) dto)
						.getBeanName() + ".java"))));

		writer.write(builder.toString());
		writer.close();
		createRestWrapper((RequestBean) dto);
	}

	public void createRestWrapper(ParentDTO dto) throws IOException {
		// TODO Auto-generated method stub
		CommonUtil commonutil = new CommonUtil();
		String packageName = LocalConstant.PACKAGE_REST;
		StringBuilder builder = new StringBuilder();
		builder.append("package ").append(packageName).append(";\n");
		
		builder = commonutil.createRestWrapper(builder, (RequestBean)dto);
		File dir = new File(packageName.replaceAll("\\.",
				Matcher.quoteReplacement(System.getProperty("file.separator"))));
		System.err.println("path--" + dir.getAbsolutePath());

		dir.mkdirs();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(dir, ((RequestBean) dto).getRestwrappername() + ".java"))));

		writer.write(builder.toString());
		writer.close();

	}

}
