package com.personal.policy.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.personal.policy.User;

public class DataStore {
	
	private final String SHARED_PREF_USER = "user.info";
	private final String STR_USER_ID = "user.info.id";
	private Context context;
	
	public DataStore( Context context) {
		this.context = context;
	}
	
	public void saveUserId( String userId) {
		SharedPreferences s = context.getSharedPreferences(SHARED_PREF_USER, 0);
		Editor e = s.edit();
		e.putString(STR_USER_ID, userId);
		e.commit();
	}
	
	public String getUserId () {
		SharedPreferences s = context.getSharedPreferences(SHARED_PREF_USER, 0);
		return s.getString(STR_USER_ID, null);
	}
	
	public User getUserInfo() {
		
		User user = new User();
		
		return user;
	}
	
	public void saveUserInfo( User user ) {
		
	}
}
