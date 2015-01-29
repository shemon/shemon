package com.shemon.atmboothsfinder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {
	public static final String TABLE_NAME = "atm_booth";
	public static final String COLUMNL_ID_FIELD = "_id";
	public static final String COLUMNL_NAME_FIELD = "name";
	public static final String COLUMNL_ADDRESS_FIELD = "address";
	public static final String COLUMNL_BANK_FIELD = "bank";
	public static final String COLUMNL_DEPOSIT_FIELD = "deposit";
	public static final String COLUMNL_CONTACTNAME_FIELD = "contactname";
	public static final String COLUMNL_CONTACTNO_FIELD = "contactno";
	public static final String COLUMNL_LATITUDE_FIELD = "latitude";
	public static final String COLUMNL_LONGITUDE_FIELD = "longitude";
	
	private static final String DATABASE_NAME = "ATM.db";
	private static final int DATABASE_VERSION = 1;
	
	public static final String TABLE_CRATE_SQL = "create table "
			+ TABLE_NAME + "(" + COLUMNL_ID_FIELD + " INTEGER PRIMARY KEY, " 
			+ COLUMNL_NAME_FIELD + " text, "
			+ COLUMNL_ADDRESS_FIELD + " text, "
			+ COLUMNL_BANK_FIELD + " text, "
			+ COLUMNL_DEPOSIT_FIELD + " text, "
			+ COLUMNL_CONTACTNAME_FIELD + " text, "
			+ COLUMNL_CONTACTNO_FIELD + " text, "
			+ COLUMNL_LATITUDE_FIELD + " text, "
			+ COLUMNL_LONGITUDE_FIELD + " text)";

	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(TABLE_CRATE_SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(SQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
	
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}
	
	

}
