package com.example.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "students.db",
                               TABLE_NAME = "students",
                               COLUMN_1 = "ROLL_NO",
                               COLUMN_2 = "FIRST_NAME",
                               COLUMN_3 = "LAST_NAME",
                               COLUMN_4 = "EMAIL";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ROLL_NO VARCHAR(10) PRIMARY KEY, FIRST_NAME VARCHAR(10), LAST_NAME VARCHAR(10), EMAIL VARCHAR(30));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String rollNo, String firstName, String lastName, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(COLUMN_1, rollNo);
        content.put(COLUMN_2, firstName);
        content.put(COLUMN_3, lastName);
        content.put(COLUMN_4, email);

        long result = db.insert(TABLE_NAME, null, content);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public Integer updateData(String rollNo, String firstName, String lastName, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(COLUMN_1, rollNo);
        content.put(COLUMN_2, firstName);
        content.put(COLUMN_3, lastName);
        content.put(COLUMN_4, email);

        return db.update(TABLE_NAME, content, "ROLL_NO = ?", new String[] {rollNo});
    }

    public Integer deleteData(String rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ROLL_NO = ?", new String[] {rollNo});
    }
}
