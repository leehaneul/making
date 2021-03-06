package com.example.a3r1;

 
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
 
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
 
    public MySQLiteOpenHelper(Context context, String name,
            CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        // 최초 db 생성 작업
        
        String sql = "create table building" +
                "(id integer primary key autoincrement, " +
                "name text, " +
                "address text);";
        db.execSQL(sql);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        String sql = "drop table if exists building;";
        onCreate(db); // table 다시 만들기
    }
}
 
