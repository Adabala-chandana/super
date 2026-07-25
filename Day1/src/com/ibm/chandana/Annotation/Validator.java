package com.ibm.chandana.Annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Validator {
	private static final Map<Class<?>, List<Field>> fields = new ConcurrentHashMap<>();

	public static  List<String> validate(Object obj) {
		if(obj==null) {
			List<String> list = List.of("Object is null");
			return list;
		}
		List<Field> fs = fields.computeIfAbsent(obj.getClass(), Validator::getDeclaredFieldsAnnotation);
		List<String> l = new ArrayList<>(fs.size());
		for (Field f : fs) {
			Object obj1;
			try {
				obj1 = f.get(obj);
				if (obj1 == null) {
					l.add(f.getName() + " should not be null");
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
		return l;
	}

	private static List<Field> getDeclaredFieldsAnnotation(Class<?> class1) {
		Field[] f = class1.getDeclaredFields();
		List<Field> fields = new ArrayList<>();
		for (Field f1 : f) {
			if (f1.getAnnotation(NotNull.class) != null) {
				f1.setAccessible(true);
				fields.add(f1);
			}
		}
		return fields;
	}
}

