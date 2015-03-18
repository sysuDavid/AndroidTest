package com.example.test;


import android.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;


import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.tencentmap.mapsdk.map.MapActivity;
import com.tencent.tencentmap.mapsdk.map.MapView;




public class Map extends MapActivity implements OnTouchListener {
	//MyMapOverlay mOverlay = new MyMapOverlay(Map.this);
	boolean longClick;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        MapView mapview = (MapView)findViewById(R.id.mapview);
        
        // 定位按钮
        Button locButton = (Button)findViewById(R.id.loc_button);
        locButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				TencentLocationRequest request = TencentLocationRequest.create();
				LocListener listener = new LocListener();
				Context context = Map.this;
				TencentLocationManager locationManager = 
						TencentLocationManager.getInstance(context);
				locationManager.requestLocationUpdates(request, listener);
			}
		});
        
        // 测试腾讯地图的长按重写
        mapview.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				
				longClick = true;
				return false;
			}
		});
        mapview.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("X-------->" + event.getX());
            	System.out.println("Y-------->" + event.getY());
				if(event.getAction() == MotionEvent.ACTION_UP  && longClick) {
					String[] string = new String[]{"设置召集地点","取消"};
	            	new AlertDialog.Builder(Map.this).setCancelable(false).setItems(string, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							switch (arg1) {
							case 0: 
								break;
							case 1:
								break;
							default:
								break;
							}
						}
					}).show();
				}
				return false;
			}
		});
        // end 长按测试
    }
	
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return true;
	}
}
