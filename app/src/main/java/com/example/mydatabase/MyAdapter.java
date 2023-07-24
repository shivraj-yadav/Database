package com.example.mydatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    Context context;
    private ArrayList name,pass;

    public MyAdapter(Context context, ArrayList name, ArrayList pass) {
        this.context = context;
        this.name = name;
        this.pass = pass;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentery,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.pass.setText(String.valueOf(pass.get(position)));
    }

    @Override
    public int getItemCount() {

        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,pass;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            pass=itemView.findViewById(R.id.pass);
        }
    }
}
