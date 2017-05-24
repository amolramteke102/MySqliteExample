package com.encureit.mysqliteexample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.encureit.mysqliteexample.model.RegisterForm;

import java.util.ArrayList;

/**
 * Created by root on 23/5/17.
 */

public class Adapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<RegisterForm> arrayList;
    TextView textName,textMobile,textEmail,textCity;
    public Adapter(Context context, ArrayList<RegisterForm>arrayList) {
        super(context, 0);
        this.context = context;
       this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) layoutInflater.inflate(R.layout.form_list, null);
        } else {
            layout = (LinearLayout) convertView;
        }

        textName=(TextView)layout.findViewById(R.id.textName);
        textMobile=(TextView)layout.findViewById(R.id.textMobile);
      //  textCity=(TextView)layout.findViewById(R.id.textCity);
       // textEmail=(TextView)layout.findViewById(R.id.textEmail);

        RegisterForm form=arrayList.get(position);
        textName.setText(form.getName());
        textMobile.setText(form.getMobileNumber());
       // textEmail.setText(form.getEmail());
       // textCity.setText(form.getCity());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToQuickPay(position);
            }
        });


        return layout;

    }

    public void goToQuickPay(int position){
        if (arrayList!=null){
            if (arrayList.size()!=0){

                Intent intent=new Intent(getContext(),FullDetailsActivity.class);
                intent.putExtra("name",this.arrayList.get(position).getName());
                intent.putExtra("mobile",this.arrayList.get(position).getMobileNumber());
                intent.putExtra("city",this.arrayList.get(position).getCity());
                intent.putExtra("email",this.arrayList.get(position).getEmail());
                this.context.startActivity(intent);


               // this.context.startActivity(new Intent(this.context, FullDetailsActivity.class).putExtra("form",this.arrayList.get(position).getName()));

                //this.context.startActivity(new Intent(this.context, StudentInfoActivity.class));
            }else {
                Toast.makeText(this.context,"Service side issue",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this.context,"Service side issue",Toast.LENGTH_SHORT).show();
        }
    }


}
