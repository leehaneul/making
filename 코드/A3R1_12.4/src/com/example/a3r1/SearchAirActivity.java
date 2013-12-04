package com.example.a3r1;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SearchAirActivity extends Activity{
	WebView mWebView;
	 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchair);
 
        WebView browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient() {
             
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        browser.loadUrl("https://www.airasiago.com/en-my/?utm_campaign=package&utm_medium=query_module&utm_source=airasia&w=pkg&searchType=pkg&NumRooms=1&NumAdults=1&tid=91291b1c-bc6e-43d2-9111-a399ebe68d3f");
    }
}
