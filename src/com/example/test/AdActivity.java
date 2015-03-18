package com.example.test;

import com.otomod.ad.AdSize;
import com.otomod.ad.AdView;
import com.otomod.ad.listener.O2OAdListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AdActivity extends Activity {
	private final String APP_KEY = "24b9c612239511e480c2f8bc123d7e98";
	private LinearLayout linearLayout;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ad);
		linearLayout = (LinearLayout)findViewById(R.id.adLayout);
		Button btnBanner = (Button)findViewById(R.id.btnBanner);
		btnBanner.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AdView adView = AdView.createBanner(AdActivity.this, 
						linearLayout, AdSize.AD_SMART_BANNER, APP_KEY);
				adView.setAdListener(new O2OAdListenerImpl());
				adView.request();
			}
		});
		
		Button btnPop = (Button)findViewById(R.id.btnPop);
		btnPop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AdView adView = AdView.createPopup(AdActivity.this, APP_KEY);
				adView.setAdListener(new O2OAdListenerImpl());
				adView.request();
			}
		});
		
		Button btnFull = (Button)findViewById(R.id.btnFull);
		btnFull.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AdView adView = AdView.createFullScreen(AdActivity.this, APP_KEY);
				adView.setAdListener(new O2OAdListenerImpl());
				adView.request();
			}
		});
		
		Button btnFloat = (Button)findViewById(R.id.btnFloat);
		btnFloat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AdView adView = AdView.createFullScreen(AdActivity.this, APP_KEY);
				adView.setAdListener(new O2OAdListenerImpl());
				adView.request();
			}
		});
		
		Button btnOpen = (Button)findViewById(R.id.btnOpen);
		btnOpen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AdView adView = AdView.createOpenScreen(AdActivity.this, APP_KEY);
				adView.setAdListener(new O2OAdListener() {
					
					@Override
					public void onClose() {
						// 广告关闭回调
					}
					
					@Override
					public void onClick() {
						// 广告点击回调
					}
					
					@Override
					public void onAdSuccess() {
						// 广告展示成功回调
					}
					
					@Override
					public void onAdFailed() {
						// 广告展示失败回调
					}
				});
				adView.request();
			}
		});
	}
	
	public class O2OAdListenerImpl implements O2OAdListener {

		@Override
		public void onClick() {
			Toast.makeText(AdActivity.this, "o2o广告点击", 1000).show();
		}

		@Override
		public void onClose() {
			 Toast.makeText(AdActivity.this, "o2o广告关闭", 1000).show();
		}

		@Override
		public void onAdFailed() {
			Toast.makeText(AdActivity.this, "o2o广告展示失败", 1000).show();
		}

		@Override
		public void onAdSuccess() {
			Toast.makeText(AdActivity.this, "o2o广告展示成功", 1000).show();
		}
	}
	
}
