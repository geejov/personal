package com.personal.policy.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private final String SQL_DB_SETUP = "CREATE TABLE TRANSACTIONS ( " +
											"ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
											"STOCK TEXT, "+
											"PRICE NUM, "+
											"QUANTITY NUM,"+
											"TYPE INTEGER )";
	public DatabaseHelper(Context context) {
		super(context, "stocks.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_DB_SETUP);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
