package com.example.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

// 使用SQLiteOpenHelper抽象类
public class DataBaseHelper extends SQLiteOpenHelper {
	public static final String TABLE_NAME = "user";
	private static final int DB_VERSION = 1;
	public static final String COL_ID = "id";
	public static final String COL_NAME = "name";
	// SQL建表语句：
	private static final String STRING_CREATE = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " int, " + COL_NAME + " varchar(20))";
	// 完全构造函数
	public DataBaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	// 三个参数的构造函数
	public DataBaseHelper(Context context, String name, int version) {
		this(context, name, null, version);
	}
	// 两个参数的构造函数
	public DataBaseHelper(Context context, String name) {
		this(context, name, DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		// 用SQL语句建表
		arg0.execSQL(STRING_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		arg0.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
		onCreate(arg0);
	}

}
