package com.shemon.atmboothsfinder;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;

public class MainActivity extends ActionBarActivity {
	
	Info info;
	SQDataSource atmBoothSource;
	ListView newList = null;
	ArrayList<Info> atmBoothList;
	AtmBoothAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_list);

	
		newList = (ListView)findViewById(R.id.list);

		atmBoothSource = new SQDataSource(this);
		atmBoothList = atmBoothSource.getatmBoothList();

		adapter = new AtmBoothAdapter(this, atmBoothList);
		newList.setAdapter(adapter);

		newList
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// Creating Bundle object
						Bundle b = new Bundle();

						// put id into bundle
						b.putLong("id", id);
						Intent i = new Intent(getBaseContext(),
								SaveInfoActivity.class);
						// Storing bundle object into intent
						i.putExtras(b);
						startActivity(i);
					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Take appropriate action for each action item click
		switch (item.getItemId()) {
		case R.id.add:
			// add new
			Intent i = new Intent(getBaseContext(), SaveInfoActivity.class);
			startActivity(i);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
