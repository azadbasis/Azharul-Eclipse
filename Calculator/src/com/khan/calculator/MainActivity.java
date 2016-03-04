package com.khan.calculator;

import junit.framework.TestResult;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText et1,et2;
	TextView tResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		tResult=(TextView)findViewById(R.id.tvOutput);
	}

	

	public void add(View v) {
		String s1=et1.getText().toString();
		String s2=et2.getText().toString();
		if(!s1.equals("")&&!s2.equals("")){
		Double d1=Double.parseDouble(s1);
		Double d2=Double.parseDouble(s2); 
		Double result=d1+d2;
		tResult.setText("Output"+result);
		}else{
			tResult.setText("input both value");
		}
	}

	public void minus(View v) {
		
		String s1=et1.getText().toString();
		String s2=et2.getText().toString();
		if(!s1.equals("")&&!s2.equals("")){
		Double d1=Double.parseDouble(s1);
		Double d2=Double.parseDouble(s2); 
		Double result=d1-d2;
		tResult.setText("Output"+result);
		}else{
			tResult.setText("input both value");
		}
		
	}

	public void mult(View v) {
		String s1=et1.getText().toString();
		String s2=et2.getText().toString();
		if(!s1.equals("")&&!s2.equals("")){
		Double d1=Double.parseDouble(s1);
		Double d2=Double.parseDouble(s2); 
		Double result=d1*d2;
		tResult.setText("Output"+result);
		}else{
			tResult.setText("input both value");
		}
	}

	public void divided(View v) {
		String s1=et1.getText().toString();
		String s2=et2.getText().toString();
		if(!s1.equals("")&&!s2.equals("")){
		Double d1=Double.parseDouble(s1);
		Double d2=Double.parseDouble(s2); 
		Double result=d1/d2;
		tResult.setText("Output"+result);
		}else{
			tResult.setText("input both value");
		}
		
	}
}
