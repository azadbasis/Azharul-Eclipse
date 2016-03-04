package com.androidclass.simpleapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LastActivity extends Activity {

	TextView finalTextView;
	Button wishButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_last);
		finalTextView=(TextView) findViewById(R.id.finalTextView);
		finalTextView.setText("WELCOME!!!\n"+getIntent().getStringExtra("USER_NAME"));
		wishButton=(Button) findViewById(R.id.goList);
		
		wishButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent1=new Intent(LastActivity.this, ActivityWishList.class);
				startActivity(intent1);
			}
		});
		
	}

	
}
