package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ShareActivity extends Activity {
	
	SharedPreferences preference;
	Editor editor;
	EditText name, pw;
	Button saveButton, readButton, otherButton;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share);
		
		name = (EditText)findViewById(R.id.username);
		pw = (EditText)findViewById(R.id.password);
		saveButton = (Button)findViewById(R.id.save);
		readButton = (Button)findViewById(R.id.read);
		otherButton = (Button)findViewById(R.id.other);
		// 初始化preference和editor
		preference = getSharedPreferences("demo", MODE_WORLD_READABLE);
		editor = preference.edit();
		
		saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 用 editor 写入数据到preference并提交
				editor.putString("name", name.getText().toString());
				editor.putString("pw", pw.getText().toString());
				editor.commit();
			}
		});
		
		readButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 读取preference的数据
				String nameString = preference.getString("name", null);
				String pwString = preference.getString("pw", null);
				if (nameString != null) {
					name.setText(nameString);
					pw.setText(pwString);
				}
			}
		});
		
		otherButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ShareActivity.this, ShareOtherActivity.class);
				startActivity(intent);
			}
		});

	}
}
