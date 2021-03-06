package com.automation.dao;

import java.io.IOException;
import java.util.Map;

import com.automation.dto.RequestDto;
import com.automation.util.LocalConstant;
import com.incture.automate.MethodProperty;
import com.incture.automate.ParameterProperty;
import com.incture.automate.ParentDTO;
import com.incture.automate.RequestBean;
import com.incture.automate.RequestDAO;

public class CommonUtil {

	public StringBuilder startClassCreation(int fileType,
			StringBuilder builder, String className,
			Map<String, Class<?>> fields, Map<String, String> customfields)
			throws IOException {
		for (Map.Entry<String, Class<?>> field : fields.entrySet()) {
			if (field != null && field.getValue() != null
					&& !field.getValue().isPrimitive()
					&& !field.getValue().getName().contains("lang")
					&& !builder.toString().contains(field.getValue().getName())) {
				builder.append("import ").append(field.getValue().getName())
						.append(";\n");
			}
		}
		builder.append("\n\n/**\n* Copyright � 2016 Incture Technology\n* @author Saurabh Raja & Nitin Mohan \n*\n*/\n\n");
		// if(fileType == 1){
		// for (Map.Entry<String, String> customfield : customfields.entrySet())
		// {
		// if(customfield !=null && customfield.getValue() != null){
		// builder.append(LocalConstant.PACKAGE_DTO).append(customfield.getValue())
		// .append(";\n");
		// }
		// }
		// }

		return builder;

	}

	// public String getPackageName(String className, StringBuilder builder) {
	// // TODO Auto-generated method stub
	// String packageName;
	// int idx = className.lastIndexOf('.');
	// if (idx >= 0) {
	// packageName = "com.nitin.saurabh.make";
	// } else
	// packageName = null;
	//
	// return packageName;
	// }

	public StringBuilder getPojoClass(int fileType, StringBuilder builder,
			Map<String, Class<?>> fields, Map<String, String> customfields,
			String className) {
		boolean flag = false;
		builder.append("\n	public " + className + "(");
		int size = fields.size() + customfields.size();
		for (Map.Entry<String, Class<?>> field : fields.entrySet()) {
			--size;
			String name = field.getKey();
			Class<?> type = field.getValue();
			if (type != null && type.getSimpleName() != null) {
				if (size == 0) {
					builder.append(type.getSimpleName() + " " + name);
				} else {
					builder.append(type.getSimpleName() + " " + name + ",");
				}
			}
		}
		for (Map.Entry<String, String> customfield : customfields.entrySet()) {
			--size;
			String name = customfield.getKey();
			String type = customfield.getValue();
			if (type != null) {
				if (size == 0) {
					builder.append(type + " " + name);
				} else {
					builder.append(type + " " + name + ",");
				}

			}
		}
		builder.append("){\n");
		builder.append("	super();\n");
		for (Map.Entry<String, Class<?>> field : fields.entrySet()) {
			String name = field.getKey();
			Class<?> type = field.getValue();
			if (type != null && type.getSimpleName() != null) {
				builder.append("	this." + name + " = " + name + ";\n");
			}
		}
		for (Map.Entry<String, String> customfield : customfields.entrySet()) {
			String name = customfield.getKey();
			String type = customfield.getValue();
			if (type != null) {
				builder.append("this." + name + " = " + name + "\n");
			}
		}
		builder.append("}\n");

		for (Map.Entry<String, Class<?>> field : fields.entrySet()) {
			String name = field.getKey();
			Class<?> type = field.getValue();
			String nameCapitalized = Character.toUpperCase(name.charAt(0))
					+ name.substring(1);
			if (flag)
				builder.append("\n");
			flag = true;
			if (type != null && type.getSimpleName() != null) {
				if (fileType == 2)
					builder.append("@Column(name=\"" + name.toUpperCase()
							+ "\" ,length=10)\n");
				builder.append("    private ").append(type.getSimpleName())
						.append(" ").append(name).append(";\n");
				builder.append("\n");
				builder.append("    public ").append(type.getSimpleName())
						.append(" get").append(nameCapitalized).append("()\n");
				builder.append("    {\n");
				builder.append("        return ").append(name).append(";\n");
				builder.append("    }\n");
				builder.append("\n");
				builder.append("    public void set").append(nameCapitalized)
						.append("(").append(type.getSimpleName()).append(" ")
						.append(name).append(")\n");
				builder.append("    {\n");
				builder.append("        this.").append(name).append(" = ")
						.append(name).append(";\n");
				builder.append("    }\n");
			}

		}
		flag = false;
		for (Map.Entry<String, String> customfield : customfields.entrySet()) {
			String name = customfield.getKey();
			String type = customfield.getValue();
			String nameCapitalized = Character.toUpperCase(name.charAt(0))
					+ name.substring(1);
			if (flag)
				builder.append("\n");
			flag = true;
			System.out.println("type" + type);
			if (type != null) {
				if (fileType == 2)
					builder.append("	@Column(name=\"" + name.toUpperCase()
							+ "\" )\n");
				builder.append("    private ").append(type).append(" ")
						.append(name).append(";\n");
				builder.append("\n");
				builder.append("    public ").append(type).append(" get")
						.append(nameCapitalized).append("()\n");
				builder.append("    {\n");
				builder.append("        return ").append(name).append(";\n");
				builder.append("    }\n");
				builder.append("\n");
				builder.append("    public void set").append(nameCapitalized)
						.append("(").append(type).append(" ").append(name)
						.append(")\n");
				builder.append("    {\n");
				builder.append("        this.").append(name).append(" = ")
						.append(name).append(";\n");
				builder.append("    }\n");
			}

		}

		return builder;

	}

	public StringBuilder getEntityTags(StringBuilder builder, String className) {
		builder.append("import ").append("java.io.Serializable").append(";\n");
		builder.append("import ").append("javax.persistence.*")
				.append(";\n\n\n");
		builder.append("@Entity").append("\n");
		builder.append("@Table(name=\"").append(className).append("\"")
				.append(")\n\n");
		builder.append("public class ").append(className)
				.append(" implements Serializable").append("\n");
		builder.append("{\n");

		builder.append("	private static final long serialVersionUID = 1L;\n");
		builder.append("	public" + className + " {\n		super();\n}");
		builder.append("\n");
		builder.append("\n");

		return builder;
	}

	public StringBuilder startBeanClassCreation(StringBuilder builder,
			ParentDTO dto) {
		RequestBean reqBean = null;
		if (dto instanceof RequestBean) {
			reqBean = (RequestBean) dto;
			builder.append("import ").append("javax.ejb.Stateless; \n");
			builder.append("import ").append(
					"javax.persistence.EntityManager; \n");
			builder.append("import ").append(
					"javax.persistence.PersistenceContext; \n");
			builder.append("import ").append(LocalConstant.PACKAGE_DO + "\n");
			builder.append("import ").append(LocalConstant.PACKAGE_DTO + "\n");
			builder.append("import ").append(LocalConstant.PACKAGE_DAO + "\n");
			builder.append("\n\n/**\n* Copyright � 2016 Incture Technology\n* @author Saurabh Raja & Nitin Mohan \n*\n*/\n\n");
			builder.append("\n\n@Stateless \n");
			builder.append("public class " + reqBean.getBeanName()
					+ "implements " + reqBean.getBeanName() + "Local {\n\n\n");
			builder.append("	public " + reqBean.getBeanName() + "(){\n\n		}\n ");
			builder.append("	@PersistenceContext(unitName=\""
					+ reqBean.getPersistentUnit()
					+ "\") \n	private EntityManager em;\n\n");

			for (MethodProperty mProperty : ((RequestBean) dto).getmProperty()) {
				builder.append("	public " + mProperty.getReturnType() + " "
						+ mProperty.getName() + "(");
				for (int i = 0; i < mProperty.getpProperty().size(); i++) {
					ParameterProperty inputParameter = mProperty.getpProperty()
							.get(i);
					builder.append("	"+inputParameter.getpDataType() + " "
							+ inputParameter.getpName());
					if (i + 1 != mProperty.getpProperty().size()) {
						builder.append(",");
					} else {
						builder.append("){\n");
					}
				}
				// for(ParameterProperty inputParameter :
				// mProperty.getpProperty()){
				// builder.append(
				// inputParameter.getpDataType()+" "+inputParameter.getpName());
				// }
				if (mProperty.getReturnType().equals("void")) {
					builder.append("	"+reqBean.getBeanName() + "Dao ")
							.append(Character.toLowerCase(reqBean.getBeanName().charAt(0))+reqBean.getBeanName().substring(1)+ "Dao = ")
							.append("new " + reqBean.getBeanName() + "Dao();\n");
					builder.append("	"+Character.toLowerCase(reqBean.getBeanName().charAt(0))+reqBean.getBeanName().substring(1) + "Dao.")
							.append(mProperty.getName() + "();\n");
					builder.append("	return;\n	}\n");
				} else {
					builder.append("	"+mProperty.getReturnType() + " obj = new "
							+ mProperty.getReturnType() + "();\n");
					builder.append("	"+reqBean.getBeanName() + "Dao ")
							.append(Character.toLowerCase(reqBean.getBeanName().charAt(0))+reqBean.getBeanName().substring(1)+ "Dao = ")
							.append("new " + reqBean.getBeanName() + "Dao();\n");
					builder.append("	obj = ")
							.append("	"+Character.toLowerCase(reqBean.getBeanName().charAt(0))+reqBean.getBeanName().substring(1)+ "Dao.")
							.append(mProperty.getName() + "();\n");
					builder.append("	return obj;\n	}\n");
				}

			}
		}
		builder.append("}\n\n");
		return builder;
	}

	public StringBuilder startDAOClassCreation(StringBuilder builder,
			ParentDTO dto) {
		RequestDAO reqDao = null;
		if (dto instanceof RequestDAO) {
			reqDao = (RequestDAO) dto;
			builder.append("import ").append(LocalConstant.PACKAGE_DO + "\n");
			builder.append("import ").append(LocalConstant.PACKAGE_DTO + "\n");
			
			builder.append("\n\n/**\n* Copyright � 2016 Incture Technology\n* @author Saurabh Raja & Nitin Mohan \n*\n*/\n\n");
			builder.append("public class " + reqDao.getDaoName() + "{\n\n\n");
			builder.append("public " + reqDao.getDaoName() + "(){\n\n}\n ");

			for (MethodProperty mProperty : reqDao.getmProperty()) {
				builder.append("public " + mProperty.getReturnType() + " "
						+ mProperty.getName() + "(");
				for (int i = 0; i < mProperty.getpProperty().size(); i++) {
					ParameterProperty inputParameter = mProperty.getpProperty()
							.get(i);
					builder.append(inputParameter.getpDataType() + " "
							+ inputParameter.getpName());
					if (i + 1 != mProperty.getpProperty().size()) {
						builder.append(",");
					} else {
						builder.append("){\n");
					}
				}
				if (mProperty.getReturnType().equals("void")) {
					builder.append("\n\n/**\n* Insert Your business Logic\n*\n*/ \n\n");
					builder.append("return ;\n}\n");
				} else {
					builder.append(mProperty.getReturnType() + " obj = new "
							+ mProperty.getReturnType() + "();\n");
					builder.append("\n\n/**\n* Insert Your business Logic\n*\n*/ \n\n");
					builder.append("return obj;\n}\n");
				}

			}
		}
		builder.append("}\n\n");
		return builder;
	}

	public StringBuilder createRestWrapper(StringBuilder builder, ParentDTO dto) {
		// TODO Auto-generated method stub
		RequestBean reqBean = new RequestBean();
		if (dto instanceof RequestBean) {
			reqBean = (RequestBean) dto;
			builder.append("import ").append("import javax.ws.rs.GET; \n");
			builder.append("import ").append("import javax.ws.rs.Consumes; \n");
			builder.append("import ").append("import javax.ejb.EJB; \n");
			builder.append("import ").append("import javax.ws.rs.POST; \n");
			builder.append("import ").append("import javax.ws.rs.Path; \n");
			builder.append("import ")
					.append("import javax.ws.rs.PathParam; \n");
			builder.append("import ").append("import javax.ws.rs.Produces; \n");
			builder.append("import ").append(
					"import javax.ws.rs.core.MediaType; \n");
			builder.append("import ").append(
					"import com.nitin.saurabh.make.*; \n");
			builder.append("\n\n/**\n* Copyright � 2016 Incture Technology\n* @author Saurabh Raja & Nitin Mohan \n*\n*/\n\n");

			builder.append("@Path(\"/" + reqBean.getPath() + "\") \n");
			builder.append("public class " + reqBean.getRestWrapperName()
					+ "{ \n\n");
			builder.append("@EJB \n");
			builder.append("private " + reqBean.getBeanName() + "Local "
					+ reqBean.getBeanName().toLowerCase() + "\n\n");

			for (MethodProperty mProperty : ((RequestBean) dto).getmProperty()) {
				builder.append("@Path(\"/" + mProperty.getName() + "\") \n@"
						+ mProperty.getCallType() + "\n");
				builder.append("@Consumes( { MediaType.APPLICATION_JSON })\n");
				builder.append("@Produces( { MediaType.APPLICATION_JSON })\n");
				builder.append("public " + mProperty.getReturnType() + " "
						+ mProperty.getName() + "(");
				for (int i = 0; i < mProperty.getpProperty().size(); i++) {
					ParameterProperty inputParameter = mProperty.getpProperty()
							.get(i);
					builder.append(inputParameter.getpDataType() + " "
							+ inputParameter.getpName());
					if (i + 1 != mProperty.getpProperty().size()) {
						builder.append(",");
					} else {
						builder.append("){\n");
					}
				}
				if (!mProperty.getReturnType().equalsIgnoreCase("void")) {
					builder.append(mProperty.getReturnType()
							+ " response = new " + mProperty.getReturnType()
							+ "();\n");
				}

				builder.append("response = "
						+ reqBean.getBeanName().toLowerCase() + "."
						+ mProperty.getName() + "(");
				for (int i = 0; i < mProperty.getpProperty().size(); i++) {
					ParameterProperty inputParameter = mProperty.getpProperty()
							.get(i);
					builder.append(inputParameter.getpName());
					if (i + 1 != mProperty.getpProperty().size()) {
						builder.append(",");
					} else {
						builder.append(");\n");
					}
				}
				if (mProperty.getReturnType().equals("void")) {
					builder.append("return ;\n}\n");
				} else {
					builder.append("return response;\n}\n");
				}
			}
		}
		builder.append("}\n\n");
		return builder;
	}

}
