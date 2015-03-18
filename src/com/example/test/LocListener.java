package com.example.test;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;

public class LocListener implements TencentLocationListener {
	@Override
    public void onLocationChanged(TencentLocation location, int error, String reason) {
        // do your work
		System.out.println(location.toString());
    }
 
    @Override
    public void onStatusUpdate(String name, int status, String desc) {
        // do your work
    }
    
}
