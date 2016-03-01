package com.incture.automate;

import java.util.HashMap;
import java.util.Map;

public class UtilConstantImpl {
	public static final Map<String, Class<?>> PRIMITIVE_NAME_TYPE_MAP = new HashMap<String, Class<?>>();
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
}
