package com.example.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.test.R.layout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class HandlerMessageActivity extends Activity {

	private Button button;
	private ImageView imageView;
	private static String IMAGE_PATH = "http://ww4.sinaimg.cn/bmiddle/786013a5jw1e7akotp4bcj20c80i3aao.jpg";
	private ProgressDialog dialog;
	private static int SUCCESS = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(layout.handler);
		
		button = (Button) findViewById(R.id.handler_button);
		imageView = (ImageView) findViewById(R.id.handler_imageView);
		
		dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在下载...");
		dialog.setCancelable(true);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(new MyThread()).start();
				dialog.show();
			}
		});
		
	}
	
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if (msg.what == SUCCESS) {
				byte[] data = (byte[]) msg.obj;
				Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
				imageView.setImageBitmap(bmp);
				dialog.dismiss();
			}
		}
		
	};
	
	public class MyThread implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(IMAGE_PATH);
			HttpResponse response = null;
			try {
				response = httpClient.execute(httpGet);
				if (response.getStatusLine().getStatusCode() == 200) {
					byte[] data = EntityUtils.toByteArray(response.getEntity());
					Message message = Message.obtain();
					message.obj = data;
					message.what = SUCCESS;
					handler.sendMessage(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
