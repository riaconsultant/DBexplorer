package com.automation.dao;

import java.io.IOException;
import java.util.Map;

import com.automation.dto.RequestBeanDto;

public class CommonUtil {
	
	public StringBuilder startClassCreation(StringBuilder builder, String className,
			Map<String, Class<?>> fields,Map<String, String> customfields) throws IOException{
		for (Map.Entry<String, Class<?>> field : fields.entrySet()) {
			if (field != null && field.getValue() != null && !field.getValue().isPrimitive()&& !field.getValue().getName().contains("lang")) {
				builder.append("import ").append(field.getValue().getName())
						.append(";\n");
			}
		}
		for (Map.Entry<String, String> customfield : customfields.entrySet()) {
			if(customfield !=null && customfield.getValue() != null){
				builder.append("import com.incture.common.").append(customfield.getValue())
				.append(";\n");
			}
		}
		return builder;
		
	}

//	public String getPackageName(String className, StringBuilder builder) {
//		// TODO Auto-generated method stub
//		String packageName;
//		int idx = className.lastIndexOf('.');
//		if (idx >= 0) {
//			packageName = "com.nitin.saurabh.make";
//		} else
//			packageName = null;
//
//		return packageName;
//	}

	public StringBuilder getPojoClass(int fileType, StringBuilder builder,
			Map<String, Class<?>> fields, Map<String, String> customfields) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (Map.Entry<String, Class<?>> field : fields.entrySet()) {
			String name = field.getKey();
			Class<?> type = field.getValue();
			type.getSimpleName();
			String nameCapitalized = Character.toUpperCase(name.charAt(0))
					+ name.substring(1);
			if (flag)
				builder.append("\n");
			flag = true;
			if(type!= null && type.getSimpleName()!= null){
				if(fileType == 2)
					builder.append("@Column(name=\""+name.toUpperCase()+"\" ,length=10)\n");
				builder.append("    private ").append(type.getSimpleName())
				.append(" ").append(name).append(";\n");
		builder.append("\n");
		builder.append("    public ").append(type.getSimpleName())
				.append(" get").append(nameCapitalized).append(" ()\n");
		builder.append("    {\n");
		builder.append("        return ").append(name).append(";\n");
		builder.append("    }\n");
		builder.append("\n");
		builder.append("    public void set").append(nameCapitalized)
				.append(" (").append(type.getSimpleName()).append(" ")
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
			System.out.println("type"+type);
			if(type!= null ){
				if(fileType == 2)
					builder.append("@Column(name=\""+name.toUpperCase()+"\" )\n");
				builder.append("    private ").append(type)
				.append(" ").append(name).append(";\n");
		builder.append("\n");
		builder.append("    public ").append(type)
				.append(" get").append(nameCapitalized).append(" ()\n");
		builder.append("    {\n");
		builder.append("        return ").append(name).append(";\n");
		builder.append("    }\n");
		builder.append("\n");
		builder.append("    public void set").append(nameCapitalized)
				.append(" (").append(type).append(" ")
				.append(name).append(")\n");
		builder.append("    {\n");
		builder.append("        this.").append(name).append(" = ")
				.append(name).append(";\n");
		builder.append("    }\n");
			}

		}

		return builder;
	
	}



	public StringBuilder getEntityTags(StringBuilder builder, String className) {
		// TODO Auto-generated method stub

		builder.append("import ").append("java.io.Serializable").append(";\n");
		builder.append("import ").append("javax.persistence.*").append(";\n\n\n");
		builder.append("@Entity").append("\n");
		builder.append("@Table(name=\"").append(className).append("\"").append(")\n\n");
		builder.append("public class ").append(className).append("\n");
		builder.append("{\n");

		builder.append("private static final long serialVersionUID = 1L;\n");	
		builder.append("public"+ className +" {\nsuper();\n}");
		builder.append("\n");
		builder.append("\n");
	
		return builder;
	}

	public StringBuilder startBeanClassCreation(StringBuilder builder,RequestBeanDto dto) {
		// TODO Auto-generated method stub
		builder.append("import ").append("javax.ejb.Stateless;\n");
		builder.append("import ").append("javax.persistence.EntityManager;\n");
		builder.append("import ").append("javax.persistence.PersistenceContext;\n\n\n@Stateless");
		builder.append("public class "+ dto.getBeanName() +"implements "+dto.getBeanName()+"Local {\n\n\n");
		builder.append("public "+ dto.getBeanName() +"(){\n\n}\n ");
		builder.append(" @PersistenceContext(unitName=\""+dto.getPersistentunit()+"\"\nprivate EntityManager em;\n\n");
		
		
		 
		return builder;
	}

}
