package com.example.test;

import java.io.IOException;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class XMLActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xml);
		
		// 在这里执行xml解析
		try {
			testParser();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void testParser() throws XmlPullParserException, IOException {
		// 实例化一个XmlPullParserFactory
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		// 用当前的XmlPullParserFactory实例化一个XmlPullParser
		XmlPullParser parser = factory.newPullParser();
		// 为解析器输入源，源是StringReader对象
		parser.setInput(new StringReader("<liu>I am Liuliu</liu><huo>Missing Huohuo</huo>"));
		
		// 获得当前事件的类型eventType
		int eventType = parser.getEventType();
		// while循环处理
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_DOCUMENT) {
				Log.d("test", "start document");
			} else if (eventType == XmlPullParser.END_DOCUMENT) {
				Log.d("test", "end document");
			} else if (eventType == XmlPullParser.START_TAG) {
				Log.d("test", "start tag:" + parser.getName()); // 获取tag名字用getName()
			} else if (eventType == XmlPullParser.END_TAG) {
				Log.d("test", "end tag:" + parser.getName());
			} else if (eventType == XmlPullParser.TEXT) {
				Log.d("test", "text:" + parser.getText()); // 获取tag内容用getText()
			}
			eventType = parser.next(); // 指向下一个事件
		}
	}
}
