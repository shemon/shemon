package com.shemon.atmboothsfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SaveInfoActivity extends ActionBarActivity {
String name;
String address;
String bankName;
String deposit;
String contactName;
String contactNo;
String latitude;
String longitude;
EditText nameEt;
EditText addressEt;
EditText bankNameEt;
EditText depositEt;
EditText contactNameEt;
EditText contactNoEt;
EditText latitudeEt;
EditText longitudeEt;
Button save;

Info info;
SQDataSource AtmBoothDataSource;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_info);
	AtmBoothDataSource = new SQDataSource(this);
	
	nameEt = (EditText) findViewById(R.id.atmnameET);
	addressEt = (EditText) findViewById(R.id.addressET);
	bankNameEt = (EditText) findViewById(R.id.banknameET);
	depositEt = (EditText) findViewById(R.id.depositET);
	contactNameEt = (EditText) findViewById(R.id.contact_nameET);
	contactNoEt = (EditText) findViewById(R.id.contact_noET);
	latitudeEt = (EditText) findViewById(R.id.latitudeET);
	longitudeEt = (EditText) findViewById(R.id.longitudeET);
	save = (Button) findViewById(R.id.save);
	

	save.setOnClickListener(new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			info = new Info(name, address, bankName, deposit,
					contactName, contactNo, latitude, longitude);
			long inserted = AtmBoothDataSource.addNewAtmBooth(info);
			/*if (inserted >= 0) {
				Toast.makeText(getApplicationContext(),
						getString(R.string.insert), Toast.LENGTH_LONG)
						.show();

				Intent i = new Intent(getApplicationContext(),
						HomeActivity.class);
				startActivity(i);
				finish();
			} else {
				Toast.makeText(getApplicationContext(),
						getString(R.string.fail), Toast.LENGTH_LONG).show();*/

		}
	});
}

void getDate() {
	name = nameEt.getText().toString();
	address = addressEt.getText().toString();
	bankName = bankNameEt.getText().toString();
	deposit = depositEt.getText().toString();
	contactName = contactNameEt.getText().toString();
	contactNo = contactNoEt.getText().toString();
	latitude = latitudeEt.getText().toString();
	longitude = longitudeEt.getText().toString();
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.info, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Take appropriate action for each action item click
		switch (item.getItemId()) {
		case R.id.home:
			// profile found
			home();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void home() {
		Intent i = new Intent(getBaseContext(), MainActivity.class);
		startActivity(i);

	}
}
