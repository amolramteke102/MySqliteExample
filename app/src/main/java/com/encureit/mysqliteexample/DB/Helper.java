package com.encureit.mysqliteexample.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.encureit.mysqliteexample.model.RegisterForm;
import com.encureit.mysqliteexample.utility.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 23/5/17.
 */

public class Helper extends SQLiteOpenHelper {

    public static final String DB_NAME="registerform.sqlite";
    public static final int DB_VERSION=1;


    public Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Constants.TABLE_USER + " ("
                                  + Constants.USER_ID + " integer primary key autoincrement, "
                                  + Constants.NAME + " text, "
                                  + Constants.MOBILE + " text, "
                                  + Constants.EMAILID + " text, "
                                  + Constants.CITY + " text ); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insertUser(){
        RegisterForm registerForm=new RegisterForm();
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Constants.NAME, registerForm.name);
        values.put(Constants.EMAILID,registerForm.email);
        values.put(Constants.MOBILE,registerForm.mobileNumber);
        values.put(Constants.CITY,registerForm.city);

        db.insert(Constants.TABLE_USER,null,values);
        db.close();
    }

    //getting single contact
    public RegisterForm  getForm(int id){
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.query(Constants.TABLE_USER,new String[]{Constants.NAME,Constants.CITY,Constants.USER_ID},Constants.USER_ID + "=?",
                new String[]{String.valueOf(id)},null,null,null);

        if (cursor!=null){
            cursor.moveToFirst();
        }
        RegisterForm registerForm=new RegisterForm(cursor.getString(cursor.getColumnIndex(Constants.NAME)),cursor.getString(cursor.getColumnIndex(Constants.MOBILE)),cursor.getString(cursor.getColumnIndex(Constants.EMAILID)),cursor.getString(cursor.getColumnIndex(Constants.CITY)),cursor.getString(cursor.getColumnIndex(Constants.USER_ID)));

        return registerForm;
    }

}
