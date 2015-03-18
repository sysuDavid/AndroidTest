package com.example.test;

import java.sql.SQLData;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SQLiteActivity extends Activity {
	// 调试的时候要用到adb，打开方法如下：
	// 在cmd窗口输入adb shell进入命令模式
	// ls 找到data,进入；再找一个data，进入
	// ls 找到对应包名，进入
	// ls 找到databases， 进入
	// ls 找到生产的数据库
	// sqlite3 [数据库名]，就打开了该数据库，可以进行查看跟查询
	public Button createButton, updateDBButton, insertButton, updateButton, queryButton;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite);
		
		createButton = (Button)findViewById(R.id.create_database);
		createButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 使用DataBaseHelper类建立数据库
				DataBaseHelper dbHelper = new DataBaseHelper(SQLiteActivity.this, "wj_db");
				// 要使用getReadableDatabase函数才会调用onCreate方法
				SQLiteDatabase db = dbHelper.getReadableDatabase();
			}
		});
		
		updateDBButton = (Button)findViewById(R.id.update_database);
		updateDBButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DataBaseHelper dbHelper = new DataBaseHelper(SQLiteActivity.this, "wj_db", 2);
				SQLiteDatabase db = dbHelper.getReadableDatabase();
			}
		});
		
		insertButton = (Button)findViewById(R.id.insert);
		insertButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 插入操作，先把数据放在ContentValues
				ContentValues values = new ContentValues();
				values.put("id", 1);
				values.put("name", "David");
				DataBaseHelper dbHelper = new DataBaseHelper(SQLiteActivity.this, "wj_db");
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				// 使用SQLiteDatabase的insert方法
				db.insert("user", null, values);
			}
		});
		
		updateButton = (Button)findViewById(R.id.update);
		updateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ContentValues values = new ContentValues();
				values.put("name", "David Yuan");
				DataBaseHelper dbhelper = new DataBaseHelper(SQLiteActivity.this, "wj_db");
				SQLiteDatabase db = dbhelper.getWritableDatabase();
				// update参数类型(String table, ContentValues values, String whereClause, String[] whereArgs)
				db.update("user", values, "id=?", new String[]{"1"});
			}
		});
		
		queryButton = (Button)findViewById(R.id.query);
		queryButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DataBaseHelper dbHelper = new DataBaseHelper(SQLiteActivity.this, "wj_db");
				SQLiteDatabase db = dbHelper.getReadableDatabase();
				// 查询操作要用到Cursor， query函数参数比较复杂
				Cursor cursor = db.query("user", new String[]{"id", "name"}, "id=?", new String[]{"1"}, null, null, null);
				while (cursor.moveToNext()) {
					String name = cursor.getString(cursor.getColumnIndex("name"));
					System.out.println("query------->" + name);
				}
			}
		});
	}
}
