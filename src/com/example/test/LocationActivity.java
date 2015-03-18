package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class LocationActivity extends Activity {
	
	Button locationButton;
	TextView longitude;
	TextView latitude;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);
		
		locationButton = (Button)findViewById(R.id.locationButton);
		longitude = (TextView)findViewById(R.id.longitudeTextView);
		latitude = (TextView)findViewById(R.id.latitudeTextView);
		
		locationButton.setOnClickListener(new ButtonListener());
	}
	private class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			LocationManager locationManager = (LocationManager)LocationActivity.this.getSystemService(Context.LOCATION_SERVICE);
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new myLocationListener());
		}
	}
	private class myLocationListener implements LocationListener {

		@Override
		public void onLocationChanged(Location arg0) {
			// TODO Auto-generated method stub
			System.out.println("longitude------>" + arg0.getLongitude());
			System.out.println("latitude------->" + arg0.getLatitude());
			longitude.setText(String.valueOf(arg0.getLongitude()));
			latitude.setText(String.valueOf(arg0.getLatitude()));
		}

		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
