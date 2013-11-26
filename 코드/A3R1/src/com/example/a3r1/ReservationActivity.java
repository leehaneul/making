package com.example.a3r1;

import java.util.ArrayList;

import com.example.a3r1.A3R1DataBase.A3R1;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.*;

public class ReservationActivity extends Activity implements OnClickListener{
	String str1 = "",str2 = "", name = "";
	int number, sit;
	
	private A3R1DataHelper openHelper;
	private SQLiteDatabase sdb;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reservation);
		Button btnok = (Button)findViewById(R.id.button_ok);
		final TextView Textone = (TextView)findViewById(R.id.textView_test01);
		final TextView Texttwo = (TextView)findViewById(R.id.textView_test02);
		Intent intent1 = getIntent();
		Bundle Mybundle = getIntent().getExtras();
		
		str1 = Mybundle.getString("str1");
		str2 = Mybundle.getString("str2");
		
		Textone.setText("출발지 : " + str1 );
		Texttwo.setText("도착지 : " + str2);
		
		//Data Base 
		openHelper = new A3R1DataHelper(this);
		
		sdb = openHelper.getReadableDatabase();
		
		Cursor c = sdb.query(A3R1.TABLE_NAME, null, null, null, null, null, null);
		startManagingCursor(c);
		
		if(c.getCount() == 0){
			appendInitData();
		}
		c.close();	
	} 
	// 버튼을 눌렀을 때 실행되는 메소드(명시적 인텐트)
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 첫번쨰버튼 눌렷을 때
		case R.id.button_ok:	
			  Intent intetn1 = new Intent(ReservationActivity.this, StartActivity.class);
			  startActivity(intetn1);
			  finish();
			  break;
		
		}
	}
	private void appendInitData(){
		sdb = openHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		
		//String[] arMenu1 = getResources().getStringArray(R.array.spinner_list);
		values.put("start", str1);
		values.put("end", str2);
		sdb.insert(A3R1.TABLE_NAME, null, values);
	}
	
}
