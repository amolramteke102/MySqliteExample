package com.encureit.mysqliteexample.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.encureit.mysqliteexample.DB.Helper;
import com.encureit.mysqliteexample.utility.Constants;

/**
 * Created by root on 23/5/17.
 */

public class RegisterForm {

    public String userId;
    public String name;
    public String mobileNumber;
    public String email;
    public String city;



    public RegisterForm() {
    }

    public RegisterForm(String userId,String name, String mobileNumber, String email, String city) {
        this.userId=userId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.city = city;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }




}
