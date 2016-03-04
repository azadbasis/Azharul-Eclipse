package com.androidapps.testlist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

	//Data source
	String[] osList={"Obunto","Linux","Windows","Apple IOS"};
	
	//Adapter Object
	
	ArrayAdapter<String> adapter;
	
	//View object
	
	ListView lvo;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Initialize listview
        lvo=(ListView)findViewById(R.id.listOS);
        
        //Initialize adapter
       // adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,osList);
        
       // adapter=new ArrayAdapter<String>(this, android.R.layout.check_list,R.id.chlist osList);
      
        lvo.setAdapter(adapter);
        
    }

}
