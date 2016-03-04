package com.automation.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.automation.dao.CreateJavaLayerLogic;
import com.incture.automate.MethodProperty;
import com.incture.automate.ParameterProperty;
import com.incture.automate.ParentDTO;
import com.incture.automate.RequestBean;
import com.incture.automate.RequestDto;
import com.incture.automate.RequestEntity;
import com.incture.automate.ClientRequestDto;
import com.incture.automate.UtilConstantImpl;

public class CreateDoExample {

	static String packageName;
	StringBuilder builder = new StringBuilder();

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
	
	
	
	/**1. PRIMITIVE_NAME_TYPE_MAP */
	
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
	}

	
	/** 2. List like List<String> or Map<String,String> */
	private final static Class convertToJavaUtilType(String name) {

		Class c = (Class) UtilConstantImpl.PRIMITIVE_NAME_TYPE_MAP.get(name);
		if (c == null && name.contains("<")) {
			String pUtilName = "java.util.";

			String utilClass = pUtilName + name.substring(0, name.indexOf('<'));
			String gClass = name.substring(name.indexOf('<') + 1,
					name.indexOf('>'));

			/** List,Set,Map might contain <primitive> or <UserType> or
			// <List<UserType>>.
			// keyToken,valueToken are use to store generic type..
			// like List<String> or Map<String,String> as keyToken = String
			// and keyToken,ValueToken as String,String respectively.
			// Need to implement keyToken,valueToken */

			String keyToken = null, valueToken = null;

			if (utilClass.equals("Map")) {
				StringTokenizer st = new StringTokenizer(gClass);
				keyToken = st.nextToken(",");
				valueToken = st.nextToken();
			} else {
				keyToken = gClass;
			}

			System.out.println(gClass);
			System.out.println(keyToken + " -  " + valueToken);

			try {
				c = Class.forName(utilClass);
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found");
			}

		}
		return c;
	}

	public static void createSrcBean(ParentDTO dto) {
		try {
			System.out.println("Inside createSrcBean()");
			RequestBean reqBean = null;
			if (dto instanceof RequestBean)
				reqBean = (RequestBean) dto;
			Map<String, Class<?>> rFields = new HashMap<String, Class<?>>();
			Map<String, Class<?>> pFields = new HashMap<String, Class<?>>();
			Map<String, String> rCustomFields = new HashMap<String, String>();
			Map<String, String> pCustomFields = new HashMap<String, String>();
			
			for(MethodProperty mProperty : reqBean.getmProperty()){
				if(convertToJavaClassType(mProperty.getReturnType()) == null){
					rCustomFields.put(mProperty.getName(), mProperty.getReturnType());
				}else{
					rFields.put(mProperty.getName(), convertToJavaClassType(mProperty.getReturnType()));
				}
				for(ParameterProperty pProperty: mProperty.getpProperty()){
					if(convertToJavaClassType(pProperty.getpDataType()) == null){
						pCustomFields.put(pProperty.getpName(), pProperty.getpDataType());
					}else{
						pFields.put(pProperty.getpName(), convertToJavaClassType(pProperty.getpDataType()));
					}
				}
			}
			CreateJavaLayerLogic javaLayerLogic = new CreateJavaLayerLogic();
			javaLayerLogic.createBeanClass(dto,rFields,pFields);
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
					System.out.println(reqEntity.getFieldProperty().get(i)
							.getName()
							+ "  "
							+ reqEntity.getFieldProperty().get(i).getType());
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
			System.out.println("Inside createSrcDto()");
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
					System.out
							.println(reqDto.getFieldProperty().get(i).getName()
									+ "  "
									+ reqDto.getFieldProperty().get(i)
											.getType());
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

	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}


	public static void createSrcDAO(ParentDTO dto) {

		try {
			System.out.println("Inside createSrcDAO()");
			CreateJavaLayerLogic javaLayerLogic = new CreateJavaLayerLogic();
			javaLayerLogic.createDAOClass(dto);
		} catch (Exception e) {

		}
	
		
	}

}
