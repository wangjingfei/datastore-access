package com.anying.datastore.access;

import com.google.appengine.api.datastore.DatastoreService;

public class DatastoreAccess implements Access {
	private final DatastoreService datastoreService;

	public DatastoreAccess(DatastoreService datastoreService) {
		this.datastoreService = datastoreService;
	}
}
