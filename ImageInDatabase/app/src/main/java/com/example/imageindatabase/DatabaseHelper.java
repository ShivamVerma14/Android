package com.example.imageindatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "practical.db", TABLE_NAME = "image", COLUMN_1 = "Name", COLUMN_2 = "Image";
    private String previousName = "";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (Name TEXT, Image BLOB);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertImage(String name, byte[] imageBytes) {
        previousName = name;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(COLUMN_1, name);
        content.put(COLUMN_2, imageBytes);

        long result = db.insert(TABLE_NAME, null, content);
        return result != -1;
    }

    public Cursor fetchImage(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("SELECT Image FROM " + TABLE_NAME + " WHERE Name = " + name, null);
    }

    public Integer updateImage(String name, byte[] imageBytes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(COLUMN_1, name);
        content.put(COLUMN_2, imageBytes);

        return db.update(TABLE_NAME, content, "Name = ?", new String[] {previousName});
    }

    public Integer deleteImage(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "Name = ?", new String[] {name});
    }
}
