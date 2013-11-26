package com.example.a3r1;

import java.io.Serializable;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectResActivity extends Activity implements OnClickListener, OnItemSelectedListener{
	Spinner mSpinner1;
	Spinner mSpinner2;
	String str1 = "",str2 = "";
	private ArrayList<String> arrayList;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resconnect);
		Button btnok = (Button)findViewById(R.id.button_cores_ok);
		ListView listview;
		//EditText editText;
		ArrayList<String> list;
		ArrayAdapter<String> adapter;
		listview = (ListView)findViewById(R.id.listView1);
        list = new ArrayList<String>();
        list.add("�����װ�  - ��� : ����, ���� : ����,\n���� : ĥ����õ��");
        list.add("�ѱ��װ�  - ��� : ����, ���� : ����,\n���� : ĥ����õ��");        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
        listview.setDivider(new ColorDrawable(Color.YELLOW));
        listview.setDividerHeight(2);
        ArrayList<String> spinner1;
        ArrayList<String> spinner2;
        spinner1 = new ArrayList<String>();
        spinner1.add("����");
        spinner1.add("����");
        spinner2 = new ArrayList<String>();
        spinner2.add("����");
        spinner2.add("����");
        
        ArrayAdapter<String> sp_adapter1 = new ArrayAdapter<String>
        (this,android.R.layout.simple_spinner_dropdown_item,spinner1);
        ArrayAdapter<String> sp_adapter2 = new ArrayAdapter<String>
        (this,android.R.layout.simple_spinner_dropdown_item,spinner2);
        mSpinner1 = (Spinner)findViewById(R.id.spinner1);
        mSpinner2 = (Spinner)findViewById(R.id.spinner2);
        mSpinner1.setAdapter(sp_adapter1);
        mSpinner2.setAdapter(sp_adapter2);
        mSpinner1.setOnItemSelectedListener(this);
        mSpinner2.setOnItemSelectedListener(this);
        
		// ��ư Ŭ�� �̺�Ʈ ó��
		btnok.setOnClickListener(this);

		
	} 
	// ��ư�� ������ �� ����Ǵ� �޼ҵ�(����� ����Ʈ)
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// ù������ư ������ ��
		case R.id.button_cores_ok:
			if(str1.equals(str2) == true){
				Toast toast = Toast.makeText(ConnectResActivity.this, "�������� ������� ������ �ȵ˴ϴ�.", Toast.LENGTH_SHORT);
				toast.show();
			}
			else{
				Intent intent1 = new Intent(ConnectResActivity.this, ReservationActivity.class);
				Bundle MyData = new Bundle();
				MyData.putString("str1", str1);
				MyData.putString("str2", str2);
				intent1.putExtras(MyData);
				//intent1.putExtra("str", str1);
				startActivity(intent1);
				finish();
			}
		}
	}

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			TextView text1 = (TextView)mSpinner1.getSelectedView();
			TextView text2 = (TextView)mSpinner2.getSelectedView();
			final TextView Textfirst = (TextView)findViewById(R.id.textView_test1);
			final TextView Textsecond = (TextView)findViewById(R.id.textView_test2);
			str1 = (String) text1.getText();
			str2 = (String) text2.getText();
			Textfirst.setText(str1);
			Textsecond.setText(str2);
			
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {

		}     
    
}

