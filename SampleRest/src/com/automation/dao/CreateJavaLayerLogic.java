package com.automation.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.regex.Matcher;

public class CreateJavaLayerLogic {

	
	public void createClass(int fileType,String className,
			Map<String, Class<?>> fields , Map<String, String> customfields) throws IOException{
		// TODO Auto-generated method stub
		CommonUtil commonutil = new CommonUtil();
		String packageName = "";
		StringBuilder builder= new StringBuilder();
		if(fileType == 1){
			packageName = "com.nitin.saurabh.make.dto";
		}else if(fileType ==2){
			packageName = "com.nitin.saurabh.make.do";
		}
		
		if (packageName != null)
			builder.append("package ").append(packageName).append(";\n");
		builder = commonutil.startClassCreation(builder,className,fields,customfields);
		if(fileType == 2){
			builder = commonutil.getEntityTags(builder,className);
		}
		
		builder = commonutil.getPojoClass(fileType,builder,fields,customfields);
//		builder = commonutil.getCustomPojoClass(FileType,builder,customfields);

		builder.append("}\n");
		builder.append("}\n");
		File dir = new File(packageName.replaceAll( "\\.",
				Matcher.quoteReplacement(System.getProperty("file.separator"))));
		System.err.println ("path--"+dir.getAbsolutePath());
		
	
		dir.mkdirs();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(dir, className + ".java"))));

		writer.write(builder.toString());
		writer.close();
	}

}
