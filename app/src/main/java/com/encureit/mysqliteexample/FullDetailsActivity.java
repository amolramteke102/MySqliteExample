package com.encureit.mysqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FullDetailsActivity extends AppCompatActivity {

    TextView textName,textMobile,textEmail,textCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);

        textName=(TextView)findViewById(R.id.textName);
        textEmail=(TextView)findViewById(R.id.textEmail);
        textCity=(TextView)findViewById(R.id.textCity);
        textMobile=(TextView)findViewById(R.id.textMobile);


        try {
            textName.setText(getIntent().getStringExtra("name"));
            textMobile.setText(getIntent().getStringExtra("mobile"));
            textCity.setText(getIntent().getStringExtra("city"));
            textEmail.setText(getIntent().getStringExtra("email"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
