package com.azhar.android.simpleintenapp;




import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

	TextView tvSecondActivity;
	EditText etcontact;
	Button btnPickContact;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			
			setContentView(R.layout.activity_second);
			tvSecondActivity=(TextView)findViewById(R.id.tvSecondActivity);
			etcontact=(EditText)findViewById(R.id.etcontact);
			btnPickContact=(Button)findViewById(R.id.btnPickContact);
			btnPickContact.setOnClickListener(new ClickHandler());
			
			
		} catch (Exception e) {
			Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
		}
		
		
	}
	
	public class ClickHandler implements OnClickListener{

		@Override
		public void onClick(View v) {

			try {
				
				String myData=etcontact.getText().toString();
				Intent intent=new Intent(Intent.ACTION_PICK,Uri.parse(myData));
				startActivityForResult(intent, 222);
				
				
			} catch (Exception e) {
				tvSecondActivity.setText(e.getMessage());
			}
			
		}
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		try {
			
			switch(requestCode){
			case(222):{
				if(resultCode==Activity.RESULT_OK){
					String selectedContact=data.getDataString();
					tvSecondActivity.setText(selectedContact.toString());
					Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(selectedContact));
					startActivity(intent);
				}else{
					
					tvSecondActivity.setText("Selection CANCELLED"+requestCode+""+resultCode);
				}
				break;
			}
			}
			
		} catch (Exception e) {
			Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}


}
