package com.automation.bean;

import java.util.HashMap;
import java.util.Map;

import com.automation.dao.CreateJavaLayerLogic;
import com.incture.automate.ParentDTO;
import com.incture.automate.RequestBean;
import com.incture.automate.RequestDto;
import com.incture.automate.RequestEntity;
import com.incture.automate.RequestMainDto;
import com.incture.automate.UtilConstantImpl;

public class CreateDoExample {

	static String packageName;
	StringBuilder builder = new StringBuilder();

	// private static final Map<String, Class<?>> PRIMITIVE_NAME_TYPE_MAP = new
	// HashMap<String, Class<?>>();
	// static {
	// PRIMITIVE_NAME_TYPE_MAP.put("boolean", Boolean.TYPE);
	// PRIMITIVE_NAME_TYPE_MAP.put("byte", Byte.TYPE);
	// PRIMITIVE_NAME_TYPE_MAP.put("char", Character.TYPE);
	// PRIMITIVE_NAME_TYPE_MAP.put("short", Short.TYPE);
	// PRIMITIVE_NAME_TYPE_MAP.put("int", Integer.TYPE);
	// PRIMITIVE_NAME_TYPE_MAP.put("long", Long.TYPE);
	// PRIMITIVE_NAME_TYPE_MAP.put("float", Float.TYPE);
	// PRIMITIVE_NAME_TYPE_MAP.put("double", Double.TYPE);
	// PRIMITIVE_NAME_TYPE_MAP.put("String", String.class);
	// PRIMITIVE_NAME_TYPE_MAP.put("Double", Double.class);
	// PRIMITIVE_NAME_TYPE_MAP.put("Boolean", Boolean.class);
	// PRIMITIVE_NAME_TYPE_MAP.put("Integer", Integer.class);
	// }

	// public static void createPackage(RequestNewDTO dto) {
	// CreateDoExample createExample = new CreateDoExample();
	// if (dto.getClassType().equalsIgnoreCase("DTO")) {
	// packageName = LocalConstant.PACKAGE_DTO;
	// } else if (dto.getClassType().equalsIgnoreCase("DO")) {
	// packageName = LocalConstant.PACKAGE_DO;
	// } else if (dto.getClassType().equalsIgnoreCase("DAO")) {
	// packageName = LocalConstant.PACKAGE_DAO;
	// } else if (dto.getClassType().equalsIgnoreCase("BEAN")) {
	// packageName = LocalConstant.PACKAGE_BEAN;
	// }
	// if (packageName != null)
	// createExample.builder.append("package ").append(packageName)
	// .append(";\n");
	// }

	/*
	 * public final static Class<?>[] convertToJavaClasses(Iterator<String> it,
	 * ClassLoader cl) throws ClassNotFoundException { ArrayList<Class<?>>
	 * classes = new ArrayList<Class<?>>(); while (it.hasNext()) {
	 * classes.add(convertToJavaClass(it.next(), cl)); } return
	 * classes.toArray(new Class[classes.size()]); }
	 */

	private final static Class convertToJavaClassType(String name) {
		Class c = (Class) UtilConstantImpl.PRIMITIVE_NAME_TYPE_MAP.get(name);
		if (c == null) {
			try {
				c = Class.forName(name);
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found " + name);
			}
		}
		return c;
		
		
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

		
	}

	// public void createDirectory(RequestMainDto RequestMainDto) {
	// //
	// System.out.println(maindto.getRequestBeandto()+"==="+maindto.getRequestdto());
	// if (RequestMainDto != null && RequestMainDto.getRequestBean() != null
	// && RequestMainDto.getRequestBean().size() > 0) {
	// for (RequestBean dto : RequestMainDto.getRequestBean()) {
	// createSrcBean(dto);
	// }
	//
	// }
	// if (RequestMainDto != null && RequestMainDto.getRequestDto() != null
	// && RequestMainDto.getRequestDto().size() > 0) {
	// for (RequestDto dto : RequestMainDto.getRequestDto()) {
	// createSrcDto(dto);
	// }
	//
	// }
	// if (RequestMainDto != null && RequestMainDto.getRequestEntity() != null
	// && RequestMainDto.getRequestEntity().size() > 0) {
	// for (RequestEntity dto : RequestMainDto.getRequestEntity()) {
	// createSrcEntity(dto);
	// }
	//
	// }
	// }

	public static void createSrcBean(ParentDTO dto) {
		try {
			System.out.println("Inside createSrcBean()");
			CreateJavaLayerLogic javaLayerLogic = new CreateJavaLayerLogic();
			javaLayerLogic.createBeanClass(dto);
		} catch (Exception e) {

		}
	}

	public static void createSrcEntity(ParentDTO dto) {

		System.out.println("Inside createSrcEntity()");
		try {
			RequestEntity reqEntity = null;
			if (dto instanceof RequestEntity)
				reqEntity = (RequestEntity) dto;
			reqEntity.setFieldCount(reqEntity.getFieldProperty().size());
			Map<String, Class<?>> fields = new HashMap<String, Class<?>>();
			Map<String, String> customFields = new HashMap<String, String>();
			for (int i = 0; i < reqEntity.getFieldCount(); i++) {

				if (convertToJavaClassType(reqEntity.getFieldProperty().get(i)
						.getType()) == null) {
					System.out.println(reqEntity.getFieldProperty().get(i).getName() + "  "+ reqEntity.getFieldProperty().get(i).getType());
					customFields.put(reqEntity.getFieldProperty().get(i)
							.getName(), reqEntity.getFieldProperty().get(i)
							.getType());
				} else {
					fields.put(reqEntity.getFieldProperty().get(i).getName(),
							convertToJavaClassType(reqEntity.getFieldProperty()
									.get(i).getType()));
				}

			}
			CreateJavaLayerLogic javaLayerLogic = new CreateJavaLayerLogic();
			javaLayerLogic.createClass(2, reqEntity.getEntityName(), fields,
					customFields);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createSrcDto(ParentDTO dto) {
		try {

			RequestDto reqDto = null;
			if (dto instanceof RequestDto)
				reqDto = (RequestDto) dto;
			reqDto.setFieldCount(reqDto.getFieldProperty().size());
			Map<String, Class<?>> fields = new HashMap<String, Class<?>>();
			Map<String, String> customFields = new HashMap<String, String>();
			for (int i = 0; i < reqDto.getFieldCount(); i++) {
				if (convertToJavaClassType(reqDto.getFieldProperty().get(i)
						.getType()) == null) {
					customFields.put(
							reqDto.getFieldProperty().get(i).getName(), reqDto
									.getFieldProperty().get(i).getType());
				} else {
					System.out.println(reqDto.getFieldProperty().get(i).getName() + "  "+ reqDto.getFieldProperty().get(i).getType());
					fields.put(reqDto.getFieldProperty().get(i).getName(),
							convertToJavaClassType(reqDto.getFieldProperty()
									.get(i).getType()));
				}
			}
			CreateJavaLayerLogic javaLayerLogic = new CreateJavaLayerLogic();
			javaLayerLogic.createClass(1, reqDto.getDtoName(), fields,
					customFields);

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
