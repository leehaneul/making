package com.example.a3r1;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SearchWayActivity extends Activity{
	WebView mWebView;
	int choice=0;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchair);
        
        Bundle Mybundle = getIntent().getExtras();
        choice = Mybundle.getInt("choice");
        
        WebView browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient() {
             
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        switch(choice){
        case 0:		// ��õ ����
        	 browser.loadUrl("http://www.airport.kr/airport/flightinfo/IhDepStatusList.iia");
        	 Toast toast1 = Toast.makeText(SearchWayActivity.this, "��õ ������ �װ��� ������ �Դϴ�.", Toast.LENGTH_SHORT);
        	 break;
        case 1:		// ���� ����
	       	 browser.loadUrl("http://www.airport.co.kr/mbs/gimpo/jsp/flight_schedule/domestic_list.jsp?id=gimpo_010101000000");
	       	 Toast toast2 = Toast.makeText(SearchWayActivity.this, "���� ������ �װ��� ������ �Դϴ�.", Toast.LENGTH_SHORT);
	       	 break;
        case 2:		// ���� ����
	       	 browser.loadUrl("http://www.jejuair.net/jejuair/ko_KR/booking/international/INTTimeTable.jsp");
	       	 Toast toast3 = Toast.makeText(SearchWayActivity.this, "���� ������ �װ��� ������ �Դϴ�.", Toast.LENGTH_SHORT);
	       	 break;
        }
       
    }
}
