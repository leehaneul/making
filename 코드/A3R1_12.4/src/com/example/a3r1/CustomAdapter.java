package com.example.a3r1;


import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CustomAdapter extends SQLiteOpenHelper {
    private static final String DB_NAME = "promise2.db";
    private static final int VERSION = 1;
    private static final String ID = "_id";
    private static final String START = "start";
    private static final String END = "end";
    private static final String NAME = "name";
    private static final String NUMBER = "number";
    private static final String SEAT = "seat";
    private static final String TABLE_NAME = "promise";
    private static final String CREATE_TABLE =
    		
        "CREATE TABLE " + TABLE_NAME + " (" +
        ID + " integer primary key autoincrement, " +
        START + " text not null, " +
        END + " text not null," +
        NAME + " text , "  +
        NUMBER + " text not null, " +
        SEAT + "text )";

    private SQLiteDatabase db;

    public CustomAdapter(Context context) {
        super(context, DB_NAME, null, VERSION);
        db = this.getWritableDatabase();
    }

    @Override
    public synchronized void close() {
        db.close();
        super.close();
    }

    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // create
    public boolean insertInfo(String start, String end, String name, String number, String seat) {
        ContentValues cv = new ContentValues();
        cv.put(START, start);
        cv.put(END, end);
        cv.put(NAME, name);
        cv.put(NUMBER, number);
        cv.put(SEAT, seat);
        return db.insert(TABLE_NAME, null, cv) != -1;
    }

    // read
    public ArrayList<InfoClass> getAllInfo() {
        ArrayList<InfoClass> info = new ArrayList<InfoClass>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, ID + " DESC");

        
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("ID"));
            String name =
                    c.getString(c.getColumnIndex("NAME"));
            String address =
                    c.getString(c.getColumnIndex("SEAT"));
            
            Log.i("SQLite", "select ok~! : "
                            + "(ID:"+ID+"), "
                            + "(NAME:"+NAME+"), "
                            + "(SEAT:"+SEAT+")");

        }
   /*     if (c.moveToFirst()) { // new String[] {ID, START, END, NAME, NUMBER, SEAT}
            final int indexId = c.getColumnIndex(ID);
            final int indexStart = c.getColumnIndex(START);
            final int indexEnd = c.getColumnIndex(END);
            final int indexName = c.getColumnIndex(NAME);
            final int indexNumber = c.getColumnIndex(NUMBER);
            final int indexSeat = c.getColumnIndex(SEAT);

            do {
                int id = c.getInt(indexId);
                String start = c.getString(indexStart);
                String end = c.getString(indexEnd);
                String name = c.getString(indexName);
                String number = c.getString(indexNumber);
                String seat = c.getString(indexSeat);
                info.add(new InfoClass(id,start,end,name,number,seat));        
            } while (c.moveToNext());
        }*/
        c.close();

        return info;
    }

    // update
    public boolean updateInfo(InfoClass i) {
        ContentValues cv = new ContentValues();
        cv.put(START, i.getStart());
        cv.put(END, i.getEnd());
        cv.put(NAME, i.getName());
        cv.put(NUMBER, i.getNumber());
        cv.put(SEAT, i.getSeat());
        String[] params = new String[] { Integer.toString(i.getId()) };
        int result = db.update(TABLE_NAME, cv, ID + "=?", params);
        return result > 0;
    }

    // delete
    public boolean deleteInfo(int id) {
        String[] params = new String[] { Integer.toString(id) };
        int result = db.delete(TABLE_NAME, ID + "=?", params);
        return result > 0;
    }
    
    public boolean deleteAll() {
        int result=db.delete(TABLE_NAME, null, null);
        return result > 0;
     }
}
