package com.shemon.atmboothsfinder;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQDataSource {
	private SQLiteDatabase db;
	private SQLiteHelper dbHelper;

	public SQDataSource(Context context) {
		dbHelper = new SQLiteHelper(context);
	}

	public void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	// Add data
	public long addNewAtmBooth(Info info) {
		open();
		ContentValues values = new ContentValues();
		values.put(dbHelper.COLUMNL_NAME_FIELD, info.getName());
		values.put(dbHelper.COLUMNL_ADDRESS_FIELD, info.getAdd());
		values.put(dbHelper.COLUMNL_BANK_FIELD, info.getBankName());
		values.put(dbHelper.COLUMNL_DEPOSIT_FIELD, info.getDeposit());
		values.put(dbHelper.COLUMNL_CONTACTNAME_FIELD, info.getContactName());
		values.put(dbHelper.COLUMNL_CONTACTNO_FIELD, info.getContactNo());
		values.put(dbHelper.COLUMNL_LATITUDE_FIELD, info.getLatitude());
		values.put(dbHelper.COLUMNL_LONGITUDE_FIELD, info.getLongitude());

		long inserted = db.insert(dbHelper.TABLE_NAME, null, values);
		close();
		return inserted;
	}

	// delete data
	public boolean deleteData(long id) {
		this.open();
		try {
			db.delete(dbHelper.TABLE_NAME,
					dbHelper.COLUMNL_ID_FIELD + "=" + id, null);
		} catch (Exception ex) {
			Log.e("ERROR", "data not deleted");
			return false;
		}
		this.close();
		return true;
	}

	// Getting All atm booths list
	public ArrayList<Info> getatmBoothList() {
		ArrayList<Info> atmboothlist = new ArrayList<Info>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + dbHelper.TABLE_NAME;

		open();
		Cursor cursor = db.query(dbHelper.TABLE_NAME, null, null, null, null,
				null, null);
		// all rows adding to list
		if (cursor != null && cursor.getCount() > 0) {
			cursor.moveToFirst();
			for (int i = 0; i < cursor.getCount(); i++) {
				int id = cursor.getInt(cursor
						.getColumnIndex(dbHelper.COLUMNL_ID_FIELD));
				String name = cursor.getString(cursor
						.getColumnIndex(dbHelper.COLUMNL_NAME_FIELD));
				String address = cursor.getString(cursor
						.getColumnIndex(dbHelper.COLUMNL_ADDRESS_FIELD));
				String bank = cursor.getString(cursor
						.getColumnIndex(dbHelper.COLUMNL_BANK_FIELD));
				String deposit = cursor.getString(cursor
						.getColumnIndex(dbHelper.COLUMNL_DEPOSIT_FIELD));
				String contactName = cursor.getString(cursor
						.getColumnIndex(dbHelper.COLUMNL_CONTACTNAME_FIELD));
				String contactNo = cursor.getString(cursor
						.getColumnIndex(dbHelper.COLUMNL_CONTACTNO_FIELD));
				String latitude = cursor.getString(cursor
						.getColumnIndex(dbHelper.COLUMNL_LATITUDE_FIELD));
				String longitude = cursor.getString(cursor
						.getColumnIndex(dbHelper.COLUMNL_LONGITUDE_FIELD));

				Info info = new Info(id, name, address, bank, deposit,
						contactName, contactNo, latitude, longitude);
				atmboothlist.add(info);
				cursor.moveToNext();
			}
		}
		cursor.close();
		db.close();

		return atmboothlist;
	}
	// Getting list
		public Info getAllInfo(int id) {
			Info info_all;
			// Select All Query
			String selectQuery = "SELECT  * FROM " + dbHelper.TABLE_NAME + "WHERE"
					+ dbHelper.COLUMNL_ID_FIELD + "=" + id;

			open();
			Cursor cursor = db.query(dbHelper.TABLE_NAME, null, null, null, null,
					null, null);

			cursor.moveToFirst();
			
			String name = cursor.getString(cursor
					.getColumnIndex(dbHelper.COLUMNL_NAME_FIELD));
			String address = cursor.getString(cursor
					.getColumnIndex(dbHelper.COLUMNL_ADDRESS_FIELD));
			String bank = cursor.getString(cursor
					.getColumnIndex(dbHelper.COLUMNL_BANK_FIELD));
			String deposit = cursor.getString(cursor
					.getColumnIndex(dbHelper.COLUMNL_DEPOSIT_FIELD));
			String contactName = cursor.getString(cursor
					.getColumnIndex(dbHelper.COLUMNL_CONTACTNAME_FIELD));
			String contactNo = cursor.getString(cursor
					.getColumnIndex(dbHelper.COLUMNL_CONTACTNO_FIELD));
			String latitude = cursor.getString(cursor
					.getColumnIndex(dbHelper.COLUMNL_LATITUDE_FIELD));
			String longitude = cursor.getString(cursor
					.getColumnIndex(dbHelper.COLUMNL_LONGITUDE_FIELD));

			info_all = new Info(id, name, address, bank, deposit,
					contactName, contactNo, latitude, longitude);
			cursor.moveToNext();

			cursor.close();
			db.close();

			
			return info_all;
}
}