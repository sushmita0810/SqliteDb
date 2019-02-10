package com.example.sushmita.applicationform;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHandler extends SQLiteOpenHelper {
    private static String key_id="id";
    private static String key_name="name";
    private static String key_email="email";
    private static String key_phone="phone";
    private static String key_table="user_table";



    public MyDbHandler(Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_user="CREATE TABLE "+key_table+"("+key_id+"INTEGER PRIMARY KEY,"
                +key_name +" TEXT,"+key_email+"TEXT,"+key_phone+" TEXT"+")";
        db.execSQL(create_user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public int insertUser(User user) {
         int i = 0;
         SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(key_id,user.getId());
        contentValues.put(key_name,user.getName());
        contentValues.put(key_email,user.getEmail());
        contentValues.put(key_phone,user.getPhone());
        sqLiteDatabase.insert(key_table,null,contentValues);
        i=1;
        return i;
    }
}
