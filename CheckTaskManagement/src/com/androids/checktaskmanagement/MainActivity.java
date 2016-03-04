package com.androids.checktaskmanagement;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText etName, etEmail, etPhone, etDesignation,etKeyword,etId,etNewName;
	DatabaseHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etName = (EditText) findViewById(R.id.etName);
		etEmail = (EditText) findViewById(R.id.etEmail);
		etPhone = (EditText) findViewById(R.id.etPhone);
		etDesignation = (EditText) findViewById(R.id.etDesignation);
		etKeyword = (EditText) findViewById(R.id.etKeyword);
		etId = (EditText) findViewById(R.id.etEid);
		etNewName = (EditText) findViewById(R.id.etNewName);
		dbHelper = new DatabaseHelper(this);
	}

	public void save(View v) {

		String name = etName.getText().toString();
		String email = etEmail.getText().toString();
		String phone = etPhone.getText().toString();
		String designation = etDesignation.getText().toString();
		Employee employee = new Employee(name, email, phone, designation);
		Toast.makeText(getApplicationContext(), employee.toString(),
				Toast.LENGTH_LONG).show();

		long inserted = dbHelper.insertEmployee(employee);
		if (inserted >= 0) {
			Toast.makeText(getApplicationContext(), "data inserted",
					Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getApplicationContext(), "data not inserted",
					Toast.LENGTH_LONG).show();
		}

	}

	public void view(View v) {
		ArrayList<Employee> employees = dbHelper.getAllEmployees();
		if (employees != null && employees.size() > 0) {
			for (Employee temp : employees) {
				Toast.makeText(getApplicationContext(), temp.toString(),
						Toast.LENGTH_LONG).show();
			}
		} else if (employees.size() == 0) {
			Toast.makeText(getApplicationContext(), "NO DATA FOUND",
					Toast.LENGTH_LONG).show();
		}

	}
	public void search(View v){
		String keyWord=etKeyword.getText().toString();
		ArrayList<Employee> employees = dbHelper.searchEmployee(keyWord);
		if (employees != null && employees.size() > 0) {
			for (Employee temp : employees) {
				Toast.makeText(getApplicationContext(), temp.toString(),
						Toast.LENGTH_LONG).show();
			}
		} else if (employees.size() == 0) {
			Toast.makeText(getApplicationContext(), "NO DATA FOUND",
					Toast.LENGTH_LONG).show();
		}
	}
	public void update(View v){
		int eId=Integer.parseInt(etId.getText().toString());
		String newName=etNewName.getText().toString();
		int updated=dbHelper.updateEmployee(eId, newName);
		if(updated>0){
			Toast.makeText(getApplicationContext(), "row(s) updated", Toast.LENGTH_LONG).show();
		}else{
			Toast.makeText(getApplicationContext(), "Information is not Updated", Toast.LENGTH_LONG).show();
		}
	}
}
