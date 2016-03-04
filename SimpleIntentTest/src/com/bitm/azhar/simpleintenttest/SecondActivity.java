package com.bitm.azhar.simpleintenttest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		TextView resultview=(TextView)findViewById(R.id.resultid);
		resultview.setText("OPS!  "+getIntent().getStringExtra("message"));
		
	}

	
}
