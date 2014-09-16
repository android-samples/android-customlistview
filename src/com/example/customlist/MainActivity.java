package com.example.customlist;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.customlist.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	// データ
	ArrayList<HashMap<String, String>> mData;

	// アダプタ
	SimpleAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// データ構築
		mData = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map;
		map = new HashMap<String,String>();
		map.put("NAME", "Google");
		map.put("URL", "http://www.google.co.jp/");
		mData.add(map);
		map = new HashMap<String,String>();
		map.put("NAME", "Yahoo");
		map.put("URL", "http://www.yahoo.co.jp/");
		mData.add(map);
		map = new HashMap<String,String>();
		map.put("NAME", "Facebook");
		map.put("URL", "https://www.google.com/");
		mData.add(map);
		
		// アダプタ
		mAdapter = new SimpleAdapter(
			this,
			mData,
			R.layout.layout_list,
			new String[]{"NAME", "URL"},
			new int[]{R.id.textView1, R.id.textView2}
		);
		ListView listView = (ListView)findViewById(R.id.listView1);
		listView.setAdapter(mAdapter);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void buttonMethod(View button){
		EditText edit1 = (EditText)findViewById(R.id.editText1);
		EditText edit2 = (EditText)findViewById(R.id.editText2);
		String text1 = edit1.getText().toString();
		String text2 = edit2.getText().toString();

		HashMap<String,String> map = new HashMap<String,String>();
		map.put("NAME", text1);
		map.put("URL", text2);
		mData.add(map);
		
		mAdapter.notifyDataSetChanged();
	}

}
