package com.encureit.mysqliteexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.encureit.mysqliteexample.model.RegisterForm;


import java.util.List;

/**
 * Created by root on 19/4/17.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private List<RegisterForm> list_item;
    public Context context;

    public RecycleViewAdapter(List<RegisterForm> list_item, Context context) {
        this.list_item = list_item;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.form_list, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int position) {

        myViewHolder.textName.setText(list_item.get(position).getName());

        myViewHolder.textName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToQuickPay(position);
            }
        });
    }

    public void goToQuickPay(int position) {
        if (list_item != null) {
            if (list_item.size() != 0) {
                Intent intent=new Intent(this.context,FullDetailsActivity.class);
                intent.putExtra("name",this.list_item.get(position).getName());
                intent.putExtra("mobile",this.list_item.get(position).getMobileNumber());
                intent.putExtra("email",this.list_item.get(position).getEmail());
                intent.putExtra("city",this.list_item.get(position).getCity());
                this.context.startActivity(intent);



                //this.context.startActivity(new Intent(this.context, StudentInfoActivity.class));
            } else {
                Toast.makeText(this.context, "Service side issue", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this.context, "Service side issue", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return list_item.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textName,textMobile,textEmail,textCity;


        public MyViewHolder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textMobile=(TextView)itemView.findViewById(R.id.textMobile);
        }
    }
}
