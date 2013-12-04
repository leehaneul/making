package com.example.a3r1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class SearchActivity extends Activity implements OnClickListener{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		ImageView bt1 = (ImageView) findViewById(R.id.im_s_kimpo);
		ImageView bt2 = (ImageView) findViewById(R.id.im_s_inchun);
		ImageView bt3 = (ImageView) findViewById(R.id.im_s_jeju);


		// ��ư Ŭ�� �̺�Ʈ ó��
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);		
	} 
	// ��ư�� ������ �� ����Ǵ� �޼ҵ�(����� ����Ʈ)
	@Override
	public void onClick(View v) {
		Bundle MyData = new Bundle();
		switch (v.getId()) {
		// ù������ư ������ ��
		case R.id.im_s_kimpo:		// ��õ
			Intent intent1 = new Intent(SearchActivity.this, SearchWayActivity.class);
			MyData.putInt("choice", 0);
			intent1.putExtras(MyData);
			startActivity(intent1);
			break;
		case R.id.im_s_inchun:		// ����
			Intent intent2 = new Intent(SearchActivity.this, SearchWayActivity.class);
			MyData.putInt("choice", 1);
			intent2.putExtras(MyData);
			startActivity(intent2);
			break;
		case R.id.im_s_jeju:		// ����
			Intent intent3 = new Intent(SearchActivity.this, SearchWayActivity.class);
			MyData.putInt("choice", 2);
			intent3.putExtras(MyData);
			startActivity(intent3);
			break;
		}
	}
}