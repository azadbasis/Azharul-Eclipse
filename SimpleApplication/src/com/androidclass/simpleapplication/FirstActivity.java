package com.androidclass.simpleapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FirstActivity extends Activity {
	
	TextView textView;
	EditText userNameEditText;
	Button okButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        
        
        textView=(TextView) findViewById(R.id.showTextView);
        userNameEditText=(EditText) findViewById(R.id.userInputEditText);
        okButton=(Button) findViewById(R.id.okButton);
        
        
        
        okButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//button on press method
				
				String nameString=userNameEditText.getText().toString();
				Intent intent=new Intent(FirstActivity.this, LastActivity.class);
				intent.putExtra("USER_NAME", nameString);
				startActivity(intent);
			}
		});
        
        
    }
}
