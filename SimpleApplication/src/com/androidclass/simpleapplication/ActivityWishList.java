package com.androidclass.simpleapplication;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityWishList extends Activity {

	
	EditText editText;
	Button listButton;
	ListView customList;
	BaseAdapter adapter;
	ArrayList<Item> arrayList;
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_wish_list);
		initializeItem();
	}

	
	private void initializeItem(){
		editText=(EditText) findViewById(R.id.editTextList);
		listButton=(Button) findViewById(R.id.buttonList);
		customList=(ListView) findViewById(R.id.listViewCustom);
		arrayList=new ArrayList<Item>();
		adapter=new BaseAdapter() {
			
			LayoutInflater inflatter=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			@Override
			public View getView(int position, View view, ViewGroup viewGroup) {
				if(view==null){
				view=inflatter.inflate(R.layout.wish_list_item, null);
				}
				TextView itemView=(TextView)view. findViewById(R.id.wishListItemTextView);
				TextView dateView=(TextView)view. findViewById(R.id.wishListDateTextView);
				
				itemView.setText(arrayList.get(position).getWishString());
				Date date=arrayList.get(position).getDate();
				//dateView.setText(arrayList.get(position).getDate());
				dateView.setText(DateFormat.format("dd/MM/yyyy HH:mm:ss a",date));
				return view;
			}
			
		
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return arrayList.get(position);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return arrayList.size();
			}
		};
		
		customList.setAdapter(adapter);
		
		listButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String string=editText.getText().toString();
				Date date=new Date();
				Item item=new Item(string, date);
				arrayList.add(item);
				
				adapter.notifyDataSetChanged();
				editText.setText("");
				InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				inputMethodManager.hideSoftInputFromInputMethod(editText.getWindowToken(), 0);
				Toast.makeText(getBaseContext(), "ADD TO WISH LIST", Toast.LENGTH_SHORT).show();
			}
		});
		customList.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				arrayList.remove(position);
				adapter.notifyDataSetChanged();
				Toast.makeText(getBaseContext(), "REMOVE ITEM FROM LIST", Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		
	}
}
