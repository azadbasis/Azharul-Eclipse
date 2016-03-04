package com.androids.checktaskmanagement;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	public static final String DV_NAME = "task_management";
	public static final int DV_VERSION = 1;
	public static final String EMPLOYEE_TABLE = "employee";
	public static final String ID_FIELD = "_id";
	public static final String NAME_FIELD = "name";
	public static final String EMAIL_FIELD = "email";
	public static final String PHONE_FIELD = "phone";
	public static final String DESIGNATION_FIELD = "designation";
	public static final String EMPLOYEE_TABLE_SQL = "CREATE TABLE "
			+ EMPLOYEE_TABLE + " (" + ID_FIELD + " INTEGER PRIMARY KEY, "
			+ NAME_FIELD + " TEXT, " + EMAIL_FIELD + " TEXT, " + PHONE_FIELD
			+ " TEXT, " + DESIGNATION_FIELD + " TEXT)";

	public DatabaseHelper(Context context) {
		super(context, DV_NAME, null, DV_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO CREATE TABLE
		db.execSQL(EMPLOYEE_TABLE_SQL);
		Log.e("TABLE CREATE", EMPLOYEE_TABLE_SQL);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public long insertEmployee(Employee emp) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(NAME_FIELD, emp.getName());
		values.put(EMAIL_FIELD, emp.getEmail());
		values.put(PHONE_FIELD, emp.getPhone());
		values.put(DESIGNATION_FIELD, emp.getDesignation());

		long inserted = db.insert(EMPLOYEE_TABLE, null, values);
		db.close();
		return inserted;
	}

	public ArrayList<Employee> searchEmployee(String keyword) {
		ArrayList<Employee> allemployee = new ArrayList<Employee>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(EMPLOYEE_TABLE, null, "name like'%" + keyword
				+ "%'or email like'%" + keyword + "%' or phone like'%"
				+ keyword + "%'or designation like'%" + keyword + "%'", null,
				null, null, null);
		// Cursor cursor2 =
		// db.rawQuery("select * from employee where name like'%"
		// + keyword + "%'or email like'%" + keyword
		// + "%' or phone like'%" + keyword + "%'or designation like'%"
		// + keyword + "%'", null);
		if (cursor != null && cursor.getCount() > 0) {
			cursor.moveToFirst();
			for (int i = 0; i < cursor.getCount(); i++) {
				//
				int id = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
				String name = cursor.getString(cursor
						.getColumnIndex(NAME_FIELD));
				String email = cursor.getString(cursor
						.getColumnIndex(EMAIL_FIELD));
				String phone = cursor.getString(cursor
						.getColumnIndex(PHONE_FIELD));
				String designation = cursor.getString(cursor
						.getColumnIndex(DESIGNATION_FIELD));
				Employee e = new Employee(id, name, email, phone, designation);
				allemployee.add(e);
				cursor.moveToNext();
			}
		}
		cursor.close();
		db.close();
		return allemployee;

	}

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> allEmployee = new ArrayList<Employee>();
		SQLiteDatabase db = this.getReadableDatabase();
		// String columns={NAME_FIELD,EMAIL_FIELD};
		// SELECT*FROM Employee
		Cursor cursor = db.query(EMPLOYEE_TABLE, null, null, null, null, null,
				null);

		// Cursor cursor=db.rawQuery("select * from employee",null);
		if (cursor != null && cursor.getCount() > 0) {
			cursor.moveToFirst();
			for (int i = 0; i < cursor.getCount(); i++) {
				// int id_index=cursor.getColumnIndex(ID_FIELD);
				int id = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
				String name = cursor.getString(cursor
						.getColumnIndex(NAME_FIELD));
				String email = cursor.getString(cursor
						.getColumnIndex(EMAIL_FIELD));
				String phone = cursor.getString(cursor
						.getColumnIndex(PHONE_FIELD));
				String designation = cursor.getString(cursor
						.getColumnIndex(DESIGNATION_FIELD));
				Employee e = new Employee(id, name, email, phone, designation);
				allEmployee.add(e);
				cursor.moveToNext();
			}
		}
		cursor.close();
		db.close();
		return allEmployee;
	}

	public int updateEmployee(int eId, String newName) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(NAME_FIELD, newName);
		int updated = db.update(EMPLOYEE_TABLE, values, ID_FIELD + "=?",
				new String[] { "" + eId });

		db.close();
		return updated;
	}

}
