package com.example.test;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

public class DateActivity extends Activity {
	// 该常量用于标识DatePickerDialog
	private static final int DATE_PIKER_ID = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date);
		
		Button datePickerShowButton = (Button)findViewById(R.id.showDatePickerButton);
		datePickerShowButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				showDialog(DATE_PIKER_ID);
			}
		});
	}
	// 监听用户设置的日期
	DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			// TODO Auto-generated method stub
			// 月份从0开始算起
			System.out.println(year + "-" + monthOfYear+1 + "-" + dayOfMonth);
		}
	};
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch(id) {
		case DATE_PIKER_ID:
			// 设置初始显示的年月日，实际上是2014-8-21
			return new DatePickerDialog(this, onDateSetListener, 2014, 7, 21);
		}
		return null;
	}
}
