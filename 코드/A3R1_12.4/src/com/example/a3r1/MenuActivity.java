package com.example.a3r1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends Activity implements OnClickListener{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		ImageView bt1 = (ImageView) findViewById(R.id.im_reservation);
		ImageView bt2 = (ImageView) findViewById(R.id.im_cancel);
		ImageView bt3 = (ImageView) findViewById(R.id.im_search);
		ImageView bt4 = (ImageView) findViewById(R.id.im_searchair);
		ImageView bt5 = (ImageView) findViewById(R.id.im_searchairport);
		ImageView bt6 = (ImageView) findViewById(R.id.im_telephone);

		// 버튼 클릭 이벤트 처리
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
		bt6.setOnClickListener(this);

		
	} 
	// 버튼을 눌렀을 때 실행되는 메소드(명시적 인텐트)
	@Override
	public void onClick(View v) {
		Bundle MyData = new Bundle();
		switch (v.getId()) {
		// 첫번쨰버튼 눌렷을 때
		case R.id.im_reservation:	
			  Intent intetn1 = new Intent(MenuActivity.this, ConnectResActivity.class);
			  startActivity(intetn1);
			  break;
		case R.id.im_cancel:	
			 Intent intetn2 = new Intent(MenuActivity.this, ConCancelActivity.class);
			 startActivity(intetn2);
			 break;
		case R.id.im_search:	
			 Intent intetn3 = new Intent(MenuActivity.this, conSearchActivity.class);
			 startActivity(intetn3);
			 break;
		case R.id.im_searchair:	
			 Intent intetn4 = new Intent(MenuActivity.this, SearchAirActivity.class);
			 startActivity(intetn4);
			 break;
		case R.id.im_searchairport:	
			 Intent intetn5 = new Intent(MenuActivity.this, SearchActivity.class);
			 startActivity(intetn5);
			 break;
		case R.id.im_telephone:	
			 Intent intetn6 = new Intent(MenuActivity.this, TelephoneActivity.class);
			 startActivity(intetn6);
			 break;
		}
	}
}
