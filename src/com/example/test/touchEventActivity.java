package com.example.test;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class touchEventActivity extends Activity {
	boolean isLongClickModule = false;
    float startX,startY;
    Timer timer;
    boolean isAlertShow = false;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.touch_event_test);
	}
	
	
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
        case MotionEvent.ACTION_DOWN:
            startX = ev.getX();
            startY = ev.getY();
            System.out.println("X---->" + startX);
            System.out.println("Y---->" + startY);
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    isLongClickModule = true;
                }
            }, 500);
            break;
        case MotionEvent.ACTION_MOVE:
            double deltaX = Math.sqrt((ev.getX() - startX) * (ev.getX() - startX) + (ev.getY() - startY) * (ev.getY() - startY));
            if (deltaX > 10 && timer != null) { // 移动大于10像素
                timer.cancel();
                timer = null;
            }
            System.out.println("ACTION_MOVE" + (isLongClickModule == true ? "长按" : "非长按"));
            if (isLongClickModule == true && isAlertShow == false) {
            	String[] string = new String[]{"设置召集地点","取消"};
            	new AlertDialog.Builder(touchEventActivity.this).setCancelable(false).setItems(string, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						switch (arg1) {
						case 0: 
							isAlertShow = false;
							break;
						case 1:
							isAlertShow = false;
							break;
						default:
							break;
						}
					}
				}).show();
            	isAlertShow = true;
            }
            break;
        case MotionEvent.ACTION_UP:
            isLongClickModule = false;
            break;
        }
        return true;
    }
}
