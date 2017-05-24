package com.encureit.mysqliteexample;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.encureit.mysqliteexample.DB.Helper;
import com.encureit.mysqliteexample.model.RegisterForm;
import com.encureit.mysqliteexample.utility.Constants;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextName,editTextMobile,editTextEmail,editTextCity;
    private Button buttonSubmit;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       init();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();

            }
        });
    }

    public void init(){
        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextMobile=(EditText)findViewById(R.id.editTextMobile);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editTextCity=(EditText)findViewById(R.id.editTextCity);
        buttonSubmit=(Button)findViewById(R.id.buttonSubmit);
    }

    public void submit(){
        if (TextUtils.isEmpty(editTextName.getText())){
            Toast.makeText(this,"Please Enter the Name",Toast.LENGTH_SHORT).show();
        }else if (editTextMobile.getText().length()<=10){
            Toast.makeText(this,"Please Enter the Mobile Number",Toast.LENGTH_SHORT).show();
        }else if(!editTextEmail.getText().toString().matches(emailPattern)){
            Toast.makeText(this,"Please Enter the Email",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(editTextCity.getText())){
            Toast.makeText(this,"Please Enter the City",Toast.LENGTH_SHORT).show();
        }else {


            Helper helper=new Helper(this);
            SQLiteDatabase db=helper.getWritableDatabase();

            RegisterForm registerForm=new RegisterForm();

            ContentValues values=new ContentValues();
            values.put(Constants.NAME,editTextName.getText().toString());
            values.put(Constants.EMAILID,editTextEmail.getText().toString());
            values.put(Constants.MOBILE,editTextMobile.getText().toString());
            values.put(Constants.CITY,editTextCity.getText().toString());

            db.insert(Constants.TABLE_USER,null,values);
            db.close();


            startActivity(new Intent(RegisterActivity.this,DetailsActivity.class));
            finish();
        }


    }



}
