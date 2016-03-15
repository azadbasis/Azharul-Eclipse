package com.azhar.android.simpleintenapp;

//import android.animation.IntEvaluator;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button myCall = (Button) findViewById(R.id.myCall);
		Button myWebSearch = (Button) findViewById(R.id.myWebSearch);
		Button mySendTo = (Button) findViewById(R.id.mySendTo);
		Button myGetContent = (Button) findViewById(R.id.myGetContent);
		Button myActivity = (Button) findViewById(R.id.myActivity);

		Button myViewContact = (Button) findViewById(R.id.myViewContact);
		Button myViewContactEdit = (Button) findViewById(R.id.myViewContactEdit);
		Button myViewWebPage = (Button) findViewById(R.id.myViewWebPage);
		Button myViewGeo = (Button) findViewById(R.id.myViewGeo);
		Button myMusic = (Button) findViewById(R.id.myMusic);

		Button mySendEmail = (Button) findViewById(R.id.mySendEmail);
		Button mySystem = (Button) findViewById(R.id.mySystem);
		Button myLocale = (Button) findViewById(R.id.myLocale);
		Button myActivity2 = (Button) findViewById(R.id.myActivity2);

		myCall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(Intent.ACTION_DIAL, Uri
						.parse("tel:031-6776576"));
				startActivity(intent);
			}
		});

		myWebSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
				intent.putExtra(SearchManager.QUERY, "azhar");
				startActivity(intent);
			}
		});

		mySendTo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(Intent.ACTION_SENDTO, Uri
						.parse("smsto:01717121839"));
				intent.putExtra("sms_body",
						"Hello azhar!you are most welcome in android intent");
				startActivity(intent);
			}
		});

		myGetContent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
				intent.setType("image/picture/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivity(intent);
			}
		});

		myActivity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this,
						FirstActivity.class);
				// start actitvity and wait for result
				startActivity(intent);
			}
		});

		myViewContact.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String myContact = "content://contacts/people/";
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri
						.parse(myContact));
				startActivity(intent);
			}
		});

		myViewContactEdit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String myContact = "content://com.android.contacts/raw_contacts/1";
				Intent intent = new Intent(Intent.ACTION_EDIT, Uri
						.parse(myContact));
				startActivity(intent);
			}
		});

		myViewWebPage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String myWeb = "http://www.youtube.com";
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri
						.parse(myWeb));
				startActivity(intent);
			}
		});
		
		
		myViewGeo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String myGeo = "geo:0,0?q=1860+east+18th+street+cleveland+";
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri
						.parse(myGeo));
				startActivity(intent);
			}
		});

		
		myMusic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
				startActivity(intent);
			}
		});
		
		mySendEmail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"azadbasis@gmail.com"});
				intent.putExtra(Intent.EXTRA_SUBJECT,"TEST MY APP E-MAIL");
				intent.setType("plain/text");
				intent.putExtra(Intent.EXTRA_TEXT,"IT IS MY APP TESTING  E-MAIL");
				startActivity(intent);
			}
		});
		
		mySystem.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
				startActivity(intent);
			}
		});
		
		myLocale.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(android.provider.Settings.ACTION_LOCALE_SETTINGS);
				startActivity(intent);
			}
		});
		
		myMusic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this,SecondActivity.class);
				startActivity(intent);
			}
		});

	}

}
