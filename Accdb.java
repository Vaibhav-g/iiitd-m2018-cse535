package com.example.rk.assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Accdb extends SQLiteOpenHelper {


    private static final String DB_NAME = "Sensor.db";
    private static final int DB_VERSION = 2;
    private static final String COL_ID = "ID";
    private static final String COLXAXIS = "X_AXIS";
    private static final String TABLENAME = "ACCELEROMETER";
    private static final String COLYAXIS = "Y_AXIS";
    private static final String COLZAXIS = "Z_AXIS";

    private static Accdb ac;
    private SQLiteDatabase db;

    private Accdb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    public static Accdb getInstance() {
        if (ac == null) {
            synchronized (Accdb.class) {
                if (ac == null) {

                    ac = new Accdb(MainActivity.getObj());

                }
            }
        }

        return ac;
    }


    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        String createTable = "CREATE TABLE " + TABLENAME+ "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLXAXIS + " REAL, " + COLYAXIS + " REAL, " + COLZAXIS + " REAL)";
        db.execSQL(createTable);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        onCreate(db);
    }

    public void insert(float x, float y, float z) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentvalues = new ContentValues();
        contentvalues.put("COLXAXIS", x);
        contentvalues.put("COLYAXIS", y);
        contentvalues.put("COLZAXIS", z);
        db.insert(TABLENAME, null, contentvalues);



    }
}
