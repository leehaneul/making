package com.example.a3r1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ReservationActivity extends Activity implements OnClickListener{
	
////	private CustomAdapter mDb;
	
	SQLiteDatabase db;		// sqlite를 사용하기위해서  객체생성
	MySQLiteOpenHelper helper; // 이를 위한 보조 객체 생성
	private DBManager dbmr;

	
////	private ArrayList<InfoClass> mInfo;
////	private ArrayAdapter<InfoClass> mAdapter;
	Integer i = 0;
	String str1 = "",str2 = "", name = "" , number_s ="" , seat_s = "";
	int number;
	String seat;
	
	ListView listView;
	EditText textnumb;
	EditText textseat;
	EditText textname;
	TextView Textone;
	TextView Texttwo;
	TextView TextTone;
	TextView TextTtwo;
	TextView TextTthree;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reservation);
		Button resok = (Button)findViewById(R.id.button_res_ok);
		Button seach = (Button)findViewById(R.id.button1);
		Textone = (TextView)findViewById(R.id.textView_test01);
		Texttwo = (TextView)findViewById(R.id.textView_test02);
			
		TextTone = (TextView)findViewById(R.id.textRT1);
		TextTtwo = (TextView)findViewById(R.id.textRT2);
		TextTthree = (TextView)findViewById(R.id.textRT3);
	
		textname = (EditText)findViewById(R.id.Text_name);
		textnumb = (EditText) findViewById(R.id.Text_number);
		textseat = (EditText)findViewById(R.id.Text_seat);
		
		Bundle Mybundle = getIntent().getExtras();
		
		str1 = Mybundle.getString("str1");
		str2 = Mybundle.getString("str2");
		
		Textone.setText("출발지 : " + str1 );
		Texttwo.setText("도착지 : " + str2);
		//name = textname.getText().toString();
		//i = Integer.parseInt(textnumb.getText().toString());
		
		////number_s = textnumb.getText().toString();
		////seat_s = textseat.getText().toString();
		
		
		TextTone.setText("주민번호 : " + number_s);
		TextTtwo.setText("좌석 : " + seat_s );
		TextTthree.setText("이름 : " + name);
		//textt1.setText(number);
		//textt2.setText(seat);
		
		resok.setOnClickListener(this);
		seach.setOnClickListener(this);
		
	} 
	
	public void insert (int number, String seat, String name){
		dbmr = new DBManager(this);
		// db 연결
		db = dbmr.getWritableDatabase();			// <- 이 부분 오류
                // 쓸수 있는 데이터 베이스 객체를 얻어옴
        ContentValues values = new ContentValues();
        values.put("number", number);
        values.put("seat", seat);
        values.put("name", name);
        
        db.insert("TABLE_NAME", null, values);
                // 테이블 명 , 널컬럼핵, 입력할 값 ContentValues
                 
   //     db.execSQL("insert into customers values('" + number + "', '" + seat + "', '" + name + "');");	// 테이블에 추출 정보 추가
//	    db.close(); //db를 닫는다.
  //      Log.i("db", "number: " + number + ", name : " + name + ", seat : " + seat);
    }
	// select
    public void select() {
    	dbmr = new DBManager(this);
        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용
 
        db = dbmr.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
        Cursor c = db.query("TABLE_NAME", null, null, null, null, null, null);
 
        /*
         * 위 결과는 select * from student 가 된다. Cursor는 DB결과를 저장한다. public Cursor
         * query (String table, String[] columns, String selection, String[]
         * selectionArgs, String groupBy, String having, String orderBy)
         */
 
        while (c.moveToNext()) {
            // c의 int가져와라 ( c의 컬럼 중 id) 인 것의 형태이다.
            int number = c.getInt(c.getColumnIndex("number"));
            String seat = c.getString(c.getColumnIndex("seat"));
            String name = c.getString(c.getColumnIndex("name"));
            Log.i("db", "number: " + number + ", name : " + name + ", seat : " + seat);
        }
    }


	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.button_res_ok:
			number_s = textnumb.getText().toString();
			seat_s = textseat.getText().toString();
			name = textname.getText().toString();
			//TextTone.setText("주민번호 : " + number_s );
		//	TextTtwo.setText("이름 : " + name );
			
		////	seat = Integer.parseInt(textseat.getText().toString());
			TextTone.setText("주민 : " + number_s);
			TextTtwo.setText("좌석 : " + seat_s );
			TextTthree.setText("이름 : " + name);
		//	number = Integer.parseInt(number_s);
	//		number = Integer.parseInt(textnumb.getText().toString());
			insert(number,seat_s,name);
	//		dbmr = new DBManager(this);
			// db 연결
	//		db = dbmr.getWritableDatabase();			// <- 이 부분 오류
	                // 쓸수 있는 데이터 베이스 객체를 얻어옴
	//		db.execSQL("insert into customers values('" + name + "', '" + seat_s + "', '" + number_s + "');");	// 테이블에 추출 정보 추가
	//		db.close(); //db를 닫는다.
			
			//int i = Integer.parseInt(seat);
			//if( i < 6){
			//	mDb = new CustomAdapter(this);
		    //    mInfo = mDb.getAllInfo();
		    //    mAdapter = new ArrayAdapter<InfoClass>(ReservationActivity.this, R.layout.list_row);
		    //    listView.setAdapter(mAdapter);
		     ////   mAdapter = new ArrayAdapter<InfoClass>(this, android.R.layout.simple_list_item_1, mInfo);
		  ////  listView.setAdapter(mAdapter);
		     //   mDb.insertInfo(str1,str2,name,number,seat);
		        //refreshList();
		////	}
		////	else{
		////		Toast toast = Toast.makeText(ReservationActivity.this, "좌석이 없습니다.", Toast.LENGTH_SHORT);
		////		toast.show();
		////	}
			/*
			Intent intent1 = getIntent();
			Bundle Mybundle = getIntent().getExtras();
			Intent intetn1 = new Intent(ReservationActivity.this, StartActivity.class);
			startActivity(intetn1);
			finish();*/
			break;
		case R.id.button1:
			select();
			break;
			
		}
	}
}
