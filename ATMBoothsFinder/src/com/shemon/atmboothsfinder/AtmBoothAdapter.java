package com.shemon.atmboothsfinder;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AtmBoothAdapter extends ArrayAdapter<Info> {

	private final Activity context;
	ArrayList<Info> atmBooth;

	public AtmBoothAdapter(Activity context, ArrayList<Info> atmBooth) {

		super(context, R.layout.atm_row, atmBooth);

		this.context = context;
		this.atmBooth = atmBooth;
	}

	@SuppressLint({ "ViewHolder", "InflateParams" })
	@Override
	public View getView(int position, View view, ViewGroup parent) {

		Info info;
		info = atmBooth.get(position);

		LayoutInflater inflater = context.getLayoutInflater();

		View rowView = inflater.inflate(R.layout.atm_row, null, true);

		TextView name = (TextView) rowView.findViewById(R.id.name);

		name.setText(info.getName().toString());

		return rowView;
	}

}
