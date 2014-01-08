package me.anying.datastore.access;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import me.anying.datastore.reflection.Reflection;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class DatastoreAccess implements Access {
	private final DatastoreService datastore;

	public DatastoreAccess() {
		datastore = DatastoreServiceFactory.getDatastoreService();
	}

	public DatastoreAccess(DatastoreService datastore) {
		this.datastore = datastore;
	}

	public <T> void put(T object, Class<?> clazz) throws IOException {
		Map<String, Object> fields = Reflection.parseObject(object);

		Entity entity = new Entity(clazz.getName());
		for (Entry<String, Object> field : fields.entrySet()) {
			entity.setProperty(field.getKey(), field.getValue());
		}

		datastore.put(entity);
	}
}
