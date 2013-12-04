package com.example.a3r1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


public class StartActivity extends Activity {
        public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        ImageView iv = new ImageView(this);
	        iv.setBackgroundResource(R.drawable.startscreen);
	        iv.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                Intent i = new Intent(StartActivity.this, MenuActivity.class);
	                startActivity(i);
	                finish();
	            }
	        });
	        setContentView(iv);
        }
        
}
