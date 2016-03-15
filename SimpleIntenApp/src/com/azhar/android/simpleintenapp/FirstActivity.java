package com.azhar.android.simpleintenapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends Activity {

	TextView tvActivity;
	EditText etcall;
	Button btnCallActivity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_first);
		tvActivity=(TextView)findViewById(R.id.tvActivity);
		etcall=(EditText)findViewById(R.id.etcall);
		btnCallActivity=(Button)findViewById(R.id.btnCallActivity);
		
		btnCallActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}


}
