package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button listViewButton;
	Button webButton;
	Button xmlButton;
	Button shareButton;
	Button sqliteButton;
	Button locationButton;
	Button touchEventButton;
	Button jsonButton;
	Button dateButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listViewButton = (Button)findViewById(R.id.ListViewButton);
		listViewButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
				startActivity(intent);
			}
		});
		
		webButton = (Button)findViewById(R.id.webButton);
		webButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, WebActivity.class);
				startActivity(intent);
			}
		});
		
		xmlButton = (Button)findViewById(R.id.xmlButton);
		xmlButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, XMLActivity.class);
				startActivity(intent);
			}
		});
		
		shareButton = (Button)findViewById(R.id.shareButton);
		shareButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, ShareActivity.class);
				startActivity(intent);
			}
		});
		sqliteButton = (Button)findViewById(R.id.sqliteButton);
		sqliteButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, SQLiteActivity.class);
				startActivity(intent);
			}
		});
		locationButton = (Button)findViewById(R.id.location);
		locationButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, LocationActivity.class);
				startActivity(intent);
			}
		});
		touchEventButton = (Button)findViewById(R.id.touchEventButton);
		touchEventButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, touchEventActivity.class);
				startActivity(intent);
			}
		});
		jsonButton = (Button)findViewById(R.id.jsonButton);
		jsonButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, JsonActivity.class);
				startActivity(intent);
			}
		});
		dateButton = (Button)findViewById(R.id.dateButton);
		dateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, DateActivity.class);
				startActivity(intent);
			}
		});
		Button mapButton = (Button)findViewById(R.id.mapButton);
		mapButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Map.class);
				startActivity(intent);
			}
		});
		Button adButton = (Button)findViewById(R.id.adButton);
		adButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, AdActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
