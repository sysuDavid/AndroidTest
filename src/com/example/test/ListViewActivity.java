package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListViewActivity extends Activity {
	ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_main);
		
		listView = (ListView)findViewById(R.id.list);
		// 实例化一个Arraylist, 常用HashMap类型
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		// 实例化多个HashMap, 赋值并且添加到ArrayList里面
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		HashMap<String, String> map3 = new HashMap<String, String>();
		
		map1.put("user_name", "David");
		map1.put("user_ip", "172.18.4.32");
		map2.put("user_name", "Jakied");
		map2.put("user_ip", "172.18.4.31");
		map3.put("user_name", "Pony");
		map3.put("user_ip", "172.18.4.30");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		// 设置适配器
		SimpleAdapter listAdapter = new SimpleAdapter(this,
				list, // 数据源ArrayList
				R.layout.list_item, // ListItem的XML实现
				new String[]{"user_name", "user_ip"}, // 动态数组对应的项
				new int[]{R.id.name_TextView, R.id.ip_TextView}); // XML文件中对应的项
		// 添加适配器
		listView.setAdapter(listAdapter);
		// 添加点击
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				setTitle("click the " + arg2 + " item");
			}
			
		});
	}
}
