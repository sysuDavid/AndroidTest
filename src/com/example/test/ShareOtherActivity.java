package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

public class ShareOtherActivity extends Activity {
	// 有bug，显示的界面没有任何内容
	public static final String PREFERENCE_PACKAGE = "com.example.test";
	public static final String PREFERENCE_NAME = "demo";
	public static int MODE = Context.MODE_WORLD_READABLE;
	TextView nameTextView;
	TextView pwTextView;
	
	protected void onCreate(Bundle saveInstanceState) {
		super.onCreate(saveInstanceState);
		setContentView(R.layout.share_other);
		
		Context c = null;
		try {
			c = this.createPackageContext(PREFERENCE_PACKAGE, CONTEXT_IGNORE_SECURITY);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		
		SharedPreferences preference = c.getSharedPreferences(PREFERENCE_NAME, MODE);
		String nameString = preference.getString("name", null);
		String pwString = preference.getString("pw", null);
		
		nameTextView = (TextView)findViewById(R.id.share_other_username);
		nameTextView.setText(nameString);
		pwTextView = (TextView)findViewById(R.id.share_other_password);
		pwTextView.setText(pwString);
	}
		
}
