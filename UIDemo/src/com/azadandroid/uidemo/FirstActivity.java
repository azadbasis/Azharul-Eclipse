package com.azadandroid.uidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;


public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
//        String[] countries=new String[]{"bangladesh","america","india",
//        		"pakistan","Thailand","England","canada","Philipin","Norway","Nepal","Bhutan"};
        
        String[] countries=getResources().getStringArray(R.array.countries);
        
        ArrayAdapter<String> countryAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countries);
        AutoCompleteTextView textCountries=(AutoCompleteTextView) findViewById(R.id.autoCompleteCountry);
        textCountries.setAdapter(countryAdapter);
        
        Spinner spinnerCountries=(Spinner) findViewById(R.id.spinnerCountry);
        spinnerCountries.setAdapter(countryAdapter);
    }



}
