package com.androidapps.checklist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	// data source
	String[] traineeList = { "Azhar", "Raju", "Murshed", "Suja", "Mamun",
			"Maksud", "Tania", "Sumi", "Antora", "Nusrat", "Mitul", "Nazmul" };

	// Adapter Object
	ArrayAdapter<String> adapter;

	// View object
	ListView lJava;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// initialize view
		lJava = (ListView) findViewById(R.id.listJ2EE);

		// adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, traineeList);

		// adapter = new ArrayAdapter<String>(this, R.layout.check_list,
		// R.id.textView1, traineeList);

		// Initialize adapter

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, traineeList);

		// adapter = new ArrayAdapter<String>(this, R.layout.check_list,
		// R.id.textView1, traineeList);
		lJava.setAdapter(adapter);

		lJava.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Toast.makeText(getApplicationContext(),
						"selected student:roll: " + position + " Student name: "+traineeList[position],
						Toast.LENGTH_LONG).show();

			}
		});

	}
}
