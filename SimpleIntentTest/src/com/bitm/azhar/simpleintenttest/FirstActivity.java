package com.bitm.azhar.simpleintenttest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FirstActivity extends Activity {

	EditText etdata,etcall,etsms;
	TextView textdisplay;
	Button btndata,btncall,btnsms;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        etdata=(EditText)findViewById(R.id.etId);
        etcall=(EditText)findViewById(R.id.etphoneId);
        etsms=(EditText)findViewById(R.id.etmessageId);
        btndata=(Button)findViewById(R.id.sendButton);
        btncall=(Button)findViewById(R.id.callButton);
        btnsms=(Button)findViewById(R.id.messageButton);
        textdisplay=(TextView)findViewById(R.id.showtext);
        
        btndata.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String inputdata=etdata.getText().toString();
				textdisplay.setText(inputdata);
				
				Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
				intent.putExtra("message", inputdata);
				startActivity(intent);
			}
		});
        
        
        btncall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				String inputphn=etcall.getText().toString();
				 if (inputphn.length() == 0) {
	                    Toast.makeText(getApplicationContext(), "Please Insert A No", Toast.LENGTH_LONG).show();
	                } else{
				Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+inputphn));
				//intent.setData(Uri.parse("tel:"+inputphn));
				startActivity(intent);
	                }
			}
		});
        
        btnsms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				//String smsstring=etsms.getText().toString();
				String inputphn=etcall.getText().toString();
				
				Intent intent=new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + inputphn));
				//intent.setData(Uri.parse("tel:"+smsstring));
				//intent.putExtra("message", smsstring);
				startActivity(intent);
			}
		});
        
    }

   
}
