package com.androidapps.listviewdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	// DataSource
	String[] osList = { "ubonto", "linux", "widows", "Android", "Mac osx" };
	// Adapter object
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		adapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, osList);
//		setListAdapter(adapter);

		
		 adapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.textOSName, osList);
			setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Toast.makeText(
				getApplicationContext(),
				"selected item: position: " + position + " item name: "
						+ osList[position], Toast.LENGTH_LONG).show();
	}

}
