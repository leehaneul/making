package com.example.a3r1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class TelephoneActivity extends Activity implements OnClickListener {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_telephone);
		ImageView bt1 = (ImageView) findViewById(R.id.im_kimpo);
		ImageView bt2 = (ImageView) findViewById(R.id.im_inchun);
		ImageView bt3 = (ImageView) findViewById(R.id.im_jeju);


		// ��ư Ŭ�� �̺�Ʈ ó��
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);

		
	} 
	// ��ư�� ������ �� ����Ǵ� �޼ҵ�(����� ����Ʈ)
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// ù������ư ������ ��
		case R.id.im_kimpo:		// ��õ ���� ��ȭ ����
			Intent intent4 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1577-2600"));
			startActivity(intent4);
			break;
		case R.id.im_inchun:		// ���� ���� ��ȭ ����
			Intent intent5 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1661-2626"));
			startActivity(intent5);
			break;
		case R.id.im_jeju:		// ���� ���� ��ȭ ����
			Intent intent6 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1577-2600"));
			startActivity(intent6);
			break;
		}
	}
}

