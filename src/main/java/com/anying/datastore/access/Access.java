package com.anying.datastore.access;

import java.io.IOException;

public interface Access {
	public <T> void put(T object, Class<?> clazz) throws IOException;
}
