package com.anying.datastore.reflection;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

public class ReflectionTest {

	@Test
	public void testParser() throws IOException {
		BeanObject object = new BeanObject();
		object.setId(1234);
		object.setName("Name");
		object.setDescription("Description");
		object.setFemale(false);

		Map<String, Object> fields = Reflection.parseObject(object);

		assertEquals(fields.size(), 4);
		assertEquals(fields.get("id"), 1234);
		assertEquals(fields.get("name"), "Name");
		assertEquals(fields.get("description"), "Description");
		assertEquals(fields.get("female"), false);
	}
}
