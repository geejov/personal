package com.personal.policy.db;

import android.content.Context;

public class DataStore {
	
	private DatabaseHelper helper;
	
	public DataStore ( Context context ) {
		this.helper = new DatabaseHelper(context);
	}
}
