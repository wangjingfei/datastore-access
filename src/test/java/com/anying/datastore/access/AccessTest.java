package com.anying.datastore.access;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class AccessTest {
	private Access access;

	@Before
	public void init() {
		access = new DatastoreAccess();
	}

	@Test
	public void testPut() throws IOException {
		BeanObject object = new BeanObject();
		object.setId(12345);
		object.setName("Name");
		access.put(object, BeanObject.class);
	}
}
