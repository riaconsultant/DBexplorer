package com.automation.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.regex.Matcher;

import com.automation.dto.RequestBeanDto;
import com.automation.util.*;
import com.incture.automate.FormatFactory;
import com.incture.automate.ParentDTO;
import com.incture.automate.RequestBean;
import com.incture.automate.RequestDAO;
import com.incture.automate.RequestProject;

public class CreateJavaLayerLogic {
	RequestProject reqProject = new RequestProject();

	public void createClass(int fileType, String className,
			Map<String, Class<?>> fields, Map<String, String> customfields)
			throws IOException {
		CommonUtil commonUtil = new CommonUtil();
		String packageName = "";
		StringBuilder builder = new StringBuilder();
		if (FormatFactory.rProject != null) {
			if (fileType == 1) {
				packageName = LocalConstant.PACKAGE_NAME + "."
						+ FormatFactory.rProject.getpName() + "."
						+ LocalConstant.PACKAGE_DTO;
			} else if (fileType == 2) {
				packageName = LocalConstant.PACKAGE_NAME + "."
						+ FormatFactory.rProject.getpName() + "."
						+ LocalConstant.PACKAGE_DO;
			}
		} else {
			if (fileType == 1) {
				packageName = LocalConstant.PACKAGE_NAME + "."
						+ LocalConstant.PACKAGE_DTO;
			} else if (fileType == 2) {
				packageName = LocalConstant.PACKAGE_NAME + "."
						+ LocalConstant.PACKAGE_DO;
			}
		}

		if (packageName != null)
			builder.append("package ").append(packageName).append(";\n");
		builder = commonUtil.startClassCreation(fileType, builder, className,
				fields, customfields);
		if (fileType == 2) {
			builder = commonUtil.getEntityTags(builder, className);
		} else if (fileType == 1) {
			builder.append("public class ").append(className).append("\n");
			builder.append("{\n");
		}

		builder = commonUtil.getPojoClass(fileType, builder, fields,
				customfields, className);
		// builder =
		// commonutil.getCustomPojoClass(FileType,builder,customfields);

		builder.append("}\n");
		// builder.append("}\n");
		File dir = new File(packageName.replaceAll("\\.",
				Matcher.quoteReplacement(System.getProperty("file.separator"))));
		System.err.println("path--" + dir.getAbsolutePath());

		dir.mkdirs();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(dir, className + ".java"))));

		writer.write(builder.toString());
		writer.close();
	}

	public void createBeanClass(ParentDTO dto,
			Map<String, Class<?>> returnfields, Map<String, Class<?>> fields)
			throws IOException {
String packageName = "";
		CommonUtil commonutil = new CommonUtil();
		if(FormatFactory.rProject!=null){
			packageName = LocalConstant.PACKAGE_NAME + "."
					+ FormatFactory.rProject.getpName() + "."
					+ LocalConstant.PACKAGE_BEAN;
		}else{
			packageName = LocalConstant.PACKAGE_NAME + "."
					+ LocalConstant.PACKAGE_BEAN;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("package ").append(packageName).append(";\n");
		// builder = commonutil.startBeanCreation(builder, dto);
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
		String packageName = "";
		CommonUtil commonutil = new CommonUtil();
		if(FormatFactory.rProject!=null){
			packageName = LocalConstant.PACKAGE_NAME + "."
					+ FormatFactory.rProject.getpName() + "."
					+ LocalConstant.PACKAGE_REST;
		}else{
			packageName = LocalConstant.PACKAGE_NAME + "."
					+ LocalConstant.PACKAGE_REST;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("package ").append(packageName).append(";\n");

		builder = commonutil.createRestWrapper(builder, (RequestBean) dto);
		File dir = new File(packageName.replaceAll("\\.",
				Matcher.quoteReplacement(System.getProperty("file.separator"))));
		System.err.println("path--" + dir.getAbsolutePath());

		dir.mkdirs();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(dir, ((RequestBean) dto)
						.getRestWrapperName() + ".java"))));

		writer.write(builder.toString());
		writer.close();

	}

	public void createDAOClass(ParentDTO dto) throws IOException {
		String packageName = "";
		RequestDAO reqDao = new RequestDAO();
		reqDao.setDaoName(((RequestBean) dto).getBeanName() + "Dao");
		reqDao.setmProperty(((RequestBean) dto).getmProperty());

		dto = (ParentDTO) reqDao;

		CommonUtil commonutil = new CommonUtil();
		if(FormatFactory.rProject!=null){
			packageName = LocalConstant.PACKAGE_NAME + "."
					+ FormatFactory.rProject.getpName() + "."
					+ LocalConstant.PACKAGE_DAO;
		}else{
			packageName = LocalConstant.PACKAGE_NAME + "."
					+ LocalConstant.PACKAGE_DAO;
		}
		
		
		StringBuilder builder = new StringBuilder();
		builder.append("package ").append(packageName).append(";\n");
		builder = commonutil.startDAOClassCreation(builder, dto);
		File dir = new File(packageName.replaceAll("\\.",
				Matcher.quoteReplacement(System.getProperty("file.separator"))));
		System.err.println("path--" + dir.getAbsolutePath());

		dir.mkdirs();

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(dir, reqDao.getDaoName()
						+ ".java"))));

		writer.write(builder.toString());
		writer.close();

	}

}
