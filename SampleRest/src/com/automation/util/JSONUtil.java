package com.automation.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;

import com.google.gson.Gson;
import com.incture.automate.ClientRequestDto;
import com.incture.automate.FormatFactory;

public class JSONUtil {

	public static void createProjectJsonFile(ClientRequestDto dto) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(dto);
		try {
			File dir = new File(LocalConstant.PACKAGE_NAME.replaceAll("\\.",
					Matcher.quoteReplacement(System
							.getProperty("file.separator"))));
			System.err.println("path--" + dir.getAbsolutePath());

			dir.mkdirs();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(new File(dir, FormatFactory.rProject
							.getpName() + ".json"))));

			writer.write(jsonString);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void createProjectFile(String pName) {
		try {
			File dir = new File(LocalConstant.PACKAGE_NAME.replaceAll("\\.",
					Matcher.quoteReplacement(System
							.getProperty("file.separator"))));
			System.err.println("path--" + dir.getAbsolutePath());
			dir.mkdirs();
			File file = new File(dir, "project.txt");
			
			if(!file.exists()){
    			file.createNewFile();
    		}
			FileWriter fileWritter = new FileWriter(file.getAbsoluteFile(),true);
	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	        bufferWritter.write(pName);
	        bufferWritter.newLine();
	        bufferWritter.close();
			
			
			
			
			
			
			
			
			
			
			
			
//			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
//					new FileOutputStream(file)));
//			if (file.exists()) {
//				System.out.println("****   " + file.getAbsolutePath());
//				Files.write(Paths.get(file.getAbsolutePath()),
//						pName.getBytes(), StandardOpenOption.APPEND);
//			} else {
//				writer.write(pName);
//			}
//			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
