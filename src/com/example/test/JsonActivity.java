package com.example.test;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class JsonActivity extends Activity {
	
	private static final String JSON_STRING =
	"{\"person\":{\"name\":\"John\",\"age\":30,\"children\":[{\"name\":\"Billy\",\"age\":5},{\"name\":\"Mike\",\"age\":7},{\"name\":\"Tony\",\"age\":9}]}}";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.json);
		
		TextView line1 = (TextView)findViewById(R.id.line1);
		TextView line2 = (TextView)findViewById(R.id.line2);
		TextView line3 = (TextView)findViewById(R.id.line3);
		
		try {
			
			JSONObject person = (new JSONObject(JSON_STRING)).getJSONObject("person");
			System.out.println("json");
			String name = person.getString("name");
			line1.setText("This person's name is " + name);
			line2.setText(name + " is " + person.getInt("age") + " years old");
			line3.setText(name + " has " + person.getJSONArray("children").length() + " children");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
