package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		WebView webview = new WebView(this);
		webview.setWebViewClient(new WebViewClient());
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl("http://www.baidu.com/");
		
		setContentView(webview);
	}
}
