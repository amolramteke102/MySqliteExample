package com.encureit.mysqliteexample;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.TextView;

import com.encureit.mysqliteexample.DB.Helper;
import com.encureit.mysqliteexample.model.RegisterForm;
import com.encureit.mysqliteexample.utility.Constants;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    public TextView textViewName,textViewMobileNumber,textViewEmail,textViewCity;
    public ListView list_View;
    //ArrayList<RegisterForm> arrayList = new ArrayList<>();
    ArrayList<RegisterForm> list = new ArrayList<>();
  //  Adapter adapter;
     RecycleViewAdapter mRecycleAdapter;
    RecyclerView mRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
      //  init();

        //list_View=(ListView)findViewById(R.id.list_View);
        mRecycleView=(RecyclerView)findViewById(R.id.recycleView);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

       /* mRecycleAdapter=new RecycleViewAdapter(list,this);
        mRecycleView.setAdapter(mRecycleAdapter);*/


        refresh();

       // getAllForm();
    }

  /*  public void init(){
        textViewName=(TextView)findViewById(R.id.textViewName);
        textViewMobileNumber=(TextView)findViewById(R.id.textViewMobile);
        textViewCity=(TextView)findViewById(R.id.textViewCity);
        textViewEmail=(TextView)findViewById(R.id.textViewEmail);
    }*/

    public void refresh()
    {
        //arrayList.clear();
        list.clear();
        Helper helper = new Helper(this);
        SQLiteDatabase db = helper.getReadableDatabase();



        String query="Select * from " + Constants.TABLE_USER +";";
        Cursor cursor = db.rawQuery(query, null);

        if (!cursor.isAfterLast()) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                RegisterForm form = new RegisterForm();

                 form.setName(cursor.getString(cursor.getColumnIndex(Constants.NAME)));
                 form.setMobileNumber(cursor.getString(cursor.getColumnIndex(Constants.MOBILE)));
                 form.setCity(cursor.getString(cursor.getColumnIndex(Constants.CITY)));
                 form.setEmail(cursor.getString(cursor.getColumnIndex(Constants.EMAILID)));
               // arrayList.add(form);
                list.add(form);


                //adapter = new Adapter(this, arrayList);
                //list_View.setAdapter(adapter);
                mRecycleView.setLayoutManager(new LinearLayoutManager(DetailsActivity.this));
                mRecycleAdapter=new RecycleViewAdapter(list,this);
                mRecycleView.setAdapter(mRecycleAdapter);
                cursor.moveToNext();
            }
        }
        cursor.close();

        db.close();

       // adapter.notifyDataSetChanged();
        mRecycleAdapter.notifyDataSetChanged();
    }



 //comments are gven to listViewi
}
