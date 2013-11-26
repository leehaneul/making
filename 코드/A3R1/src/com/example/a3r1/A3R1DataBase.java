package com.example.a3r1;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class A3R1DataBase implements BaseColumns{
	private A3R1DataBase(){}
	public static final class A3R1 implements BaseColumns{
		private A3R1(){}	
		//DB name & version
		public static final String DB_NAME = "a3r1.db";
		public static final int DB_VERSION = 1;
		
		//table name 
		public static String TABLE_NAME = "reservation";
		
		//column names
		public static final String START = "start";
		public static final String END = "end";
		public static final String NAME = "name";
		public static final String NUMBER = "number";
		public static final String SEET = "seet";		
	}
}
