package com.example.a3r1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ConCancelActivity extends Activity implements OnClickListener{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_canclecon);
		Button btnok = (Button)findViewById(R.id.button_concancel_ok);

		// 버튼 클릭 이벤트 처리
		btnok.setOnClickListener(this);
		
	} 
	// 버튼을 눌렀을 때 실행되는 메소드(명시적 인텐트)
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 첫번쨰버튼 눌렷을 때
		case R.id.button_concancel_ok:	
			  Intent intetn1 = new Intent(ConCancelActivity.this, CancelActivity.class);
			  startActivity(intetn1);
			  finish();
			  break;
		}
	}
}
