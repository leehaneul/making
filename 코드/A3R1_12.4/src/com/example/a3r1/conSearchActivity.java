package com.example.a3r1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class conSearchActivity extends Activity implements OnClickListener{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchcon);
		Button btnok = (Button)findViewById(R.id.button_consearch_ok);


		// ��ư Ŭ�� �̺�Ʈ ó��
		btnok.setOnClickListener(this);
		
	} 
	// ��ư�� ������ �� ����Ǵ� �޼ҵ�(����� ����Ʈ)
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// ù������ư ������ ��
		case R.id.button_consearch_ok:	
			  Intent intetn1 = new Intent(conSearchActivity.this, SearchActivity.class);
			  startActivity(intetn1);
			  finish();
			  break;
		}
	}
}
