package me.anying.datastore.reflection;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class Reflection {
	public static <T> Map<String, Object> parseObject(T object)
			throws IOException {
		Map<String, Object> fields = Maps.newHashMap();
		try {
			for (PropertyDescriptor pd : Introspector.getBeanInfo(
					object.getClass()).getPropertyDescriptors()) {
				if (pd.getReadMethod() != null && !pd.getName().equals("class")) {
					fields.put(pd.getName(), pd.getReadMethod().invoke(object));
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | IntrospectionException e) {
			System.out.println(e.getMessage());
			throw new IOException(e);
		}

		return fields;
	}
}
