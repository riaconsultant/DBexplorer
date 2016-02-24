package com.automation.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import javax.jws.WebParam;

import com.automation.dao.CreateJavaLayerLogic;
import com.automation.dto.MainDto;
import com.automation.dto.RequestDto;
import com.automation.dto.RequestEntityDto;
public class CreateDoExample {
	 private static final Map<String, Class<?>> PRIMITIVE_NAME_TYPE_MAP = new HashMap<String, Class<?>>();
		static {
			PRIMITIVE_NAME_TYPE_MAP.put("boolean", Boolean.TYPE);
			PRIMITIVE_NAME_TYPE_MAP.put("byte", Byte.TYPE);
			PRIMITIVE_NAME_TYPE_MAP.put("char", Character.TYPE);
			PRIMITIVE_NAME_TYPE_MAP.put("short", Short.TYPE);
			PRIMITIVE_NAME_TYPE_MAP.put("int", Integer.TYPE);
			PRIMITIVE_NAME_TYPE_MAP.put("long", Long.TYPE);
			PRIMITIVE_NAME_TYPE_MAP.put("float", Float.TYPE);
			PRIMITIVE_NAME_TYPE_MAP.put("double", Double.TYPE);
			PRIMITIVE_NAME_TYPE_MAP.put("String", String.class);
			PRIMITIVE_NAME_TYPE_MAP.put("Double", Double.class);
			PRIMITIVE_NAME_TYPE_MAP.put("Boolean", Boolean.class);
			PRIMITIVE_NAME_TYPE_MAP.put("Integer", Integer.class);
		}
		
		/*
		 * public final static Class<?>[] convertToJavaClasses(Iterator<String> it,
		 * ClassLoader cl) throws ClassNotFoundException { ArrayList<Class<?>>
		 * classes = new ArrayList<Class<?>>(); while (it.hasNext()) {
		 * classes.add(convertToJavaClass(it.next(), cl)); } return
		 * classes.toArray(new Class[classes.size()]); }
		 */

		private final static Class convertToJavaClassType(String name) {
			Class c = (Class) PRIMITIVE_NAME_TYPE_MAP.get(name);
//			if (c == null) {
//				try {
//					 c = Class.forName(name);
//					return c;
////					c = (Class) Class.forName(name);
//					// c = cl.loadClass(name);
//				} catch (ClassNotFoundException e) {
//					System.out.println(c+"Parameter(Type) class not found: " + name);
//				}
//
//			}

			// int arraySize = 0;
			// while (name.endsWith("[]")) {
			// name = name.substring(0, name.length() - 2);
			// arraySize++;
			// }
			// if we have an array get the array class
			// if (arraySize > 0) {
			// int[] dims = new int[arraySize];
			// for (int i = 0; i < arraySize; i++) {
			// dims[i] = 1;
			// }
			// c = Array.newInstance(c, dims).getClass();
			// }
			// System.out.println(c);

			return c;
		}
		public void createDirectory(MainDto maindto){
			if(maindto != null && maindto.getRequestdto()!=null && maindto.getRequestdto().size() > 0){
				for(RequestDto dto : maindto.getRequestdto()){
					createSrcDto(dto);
				}
				
			}
			if(maindto != null && maindto.getRequestentitydto()!=null && maindto.getRequestentitydto().size() > 0){
				for(RequestEntityDto dto : maindto.getRequestentitydto()){
					createSrcEntity(dto);
				}
				
			}
			
			
		}
		public  void createSrcEntity(RequestEntityDto dto){
			CreateDoExample obj = new CreateDoExample();
			try {
				dto.setFieldCount(dto.getFieldTypeName().size());
				Map<String, Class<?>> fields = new HashMap<String, Class<?>>();
				Map<String, String> customFields = new HashMap<String, String>();
				for (int i = 0; i < dto.getFieldTypeName().size(); i++) {
					
					if(convertToJavaClassType(dto.getFieldTypeName().get(i).getType()) == null){
						customFields.put(dto.getFieldTypeName().get(i).getName(), dto.getFieldTypeName().get(i).getType());
					}else{
						fields.put(dto.getFieldTypeName().get(i).getName(), convertToJavaClassType(dto.getFieldTypeName().get(i).getType()));
					}
					
					
				}
				CreateJavaLayerLogic javaLayerLogic = new CreateJavaLayerLogic();
				javaLayerLogic.createClass(2,dto.getEntityName(), fields , customFields);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		public  void createSrcDto(RequestDto dto){
			CreateDoExample obj = new CreateDoExample();
			try {
				dto.setFieldCount(dto.getFieldTypeName().size());
				Map<String, Class<?>> fields = new HashMap<String, Class<?>>();
				Map<String, String> customFields = new HashMap<String, String>();
				for (int i = 0; i < dto.getFieldTypeName().size(); i++) {
					if(convertToJavaClassType(dto.getFieldTypeName().get(i).getType()) == null){
						customFields.put(dto.getFieldTypeName().get(i).getName(), dto.getFieldTypeName().get(i).getType());
					}else{
						fields.put(dto.getFieldTypeName().get(i).getName(), convertToJavaClassType(dto.getFieldTypeName().get(i).getType()));
					}
				}
				CreateJavaLayerLogic javaLayerLogic = new CreateJavaLayerLogic();
				javaLayerLogic.createClass(1,dto.getDtoName(), fields,customFields);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		/*
		 * public static void createFile(String DirectoryPath) throws IOException {
		 * File file = new File(DirectoryPath); file.getParentFile().mkdirs();
		 * FileWriter writer = new FileWriter(file); writer.write("abc");
		 * writer.flush(); writer.close(); }
		 */

		
		public static boolean isNumeric(String str) {
			for (char c : str.toCharArray()) {
				if (!Character.isDigit(c))
					return false;
			}
			return true;
		}




	}


