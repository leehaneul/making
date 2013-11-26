package com.example.a3r1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MenuActivity extends Activity implements OnClickListener{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		ImageView bt1 = (ImageView) findViewById(R.id.im_reservation);
		ImageView bt2 = (ImageView) findViewById(R.id.im_cancel);
		ImageView bt3 = (ImageView) findViewById(R.id.im_search);
		ImageView bt4 = (ImageView) findViewById(R.id.im_searchair);


		// ��ư Ŭ�� �̺�Ʈ ó��
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);

		
	} 
	// ��ư�� ������ �� ����Ǵ� �޼ҵ�(����� ����Ʈ)
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// ù������ư ������ ��
		case R.id.im_reservation:	
			  Intent intetn1 = new Intent(MenuActivity.this, ConnectResActivity.class);
			  startActivity(intetn1);
			  finish();
			  break;
		case R.id.im_cancel:	
			 Intent intetn2 = new Intent(MenuActivity.this, StartActivity.class);
			 startActivity(intetn2);
			 finish();
			 break;
		case R.id.im_search:	
			 Intent intetn3 = new Intent(MenuActivity.this, StartActivity.class);
			 startActivity(intetn3);
			 finish();
			 break;
		case R.id.im_searchair:	
			 Intent intetn4 = new Intent(MenuActivity.this, StartActivity.class);
			 startActivity(intetn4);
			 finish();
			 break;
		}
	}
}
