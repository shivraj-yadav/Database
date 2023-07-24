package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class viewdata extends AppCompatActivity {
    RecyclerView RV;
    ArrayList<String> name,pass;
    dbhelper DB;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata);
        DB=new dbhelper(this);
        name=new ArrayList<>();
        pass=new ArrayList<>();
        RV=findViewById(R.id.recyleviewer);
        adapter=new MyAdapter(this,name,pass);
        RV.setAdapter(adapter);
        RV.setLayoutManager(new LinearLayoutManager(this));
        display();

    }
    public void display()
    {
        Cursor cursor=DB.getdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No Entery Exist", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
                while(cursor.moveToNext())
                {
                    name.add(cursor.getString(0));
                    pass.add(cursor.getString(1));
                }
        }
    }
}