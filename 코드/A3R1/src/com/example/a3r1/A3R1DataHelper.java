package com.example.a3r1;

import com.example.a3r1.A3R1DataBase.A3R1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class A3R1DataHelper extends SQLiteOpenHelper {
	static final String TAG = "A3R1DataHelper";
	//helper object를 통해 Database를 연다.
	public A3R1DataHelper(Context c){
		super(c,A3R1.DB_NAME,null,A3R1.DB_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL("CREATE TABLE" + A3R1.TABLE_NAME + "("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ A3R1.START + "text,"
				+ A3R1.END + "text,"
				+ A3R1.NAME + "text,"
				+ A3R1.NUMBER + "int,"
				+ A3R1.SEET + "int);");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		
		Log.w(TAG,"Version mismatch : " + oldVersion + "to " + newVersion);
		db.execSQL("DROP TABLE" + A3R1.TABLE_NAME);
		onCreate(db);
	}
}
