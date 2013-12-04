package com.example.a3r1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {
	public DBManager(Context ct){
		super(ct, "myDB", null, 1);
	}//end
	
	@Override
	public void onCreate(SQLiteDatabase db) { //create table
		db.execSQL("create table customers (name, text, sex text, sms text);");
	}//end

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
	}//end
}//main END