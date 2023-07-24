package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2;
    dbhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        b1=findViewById(R.id.insert);
        b2=findViewById(R.id.view);

        DB=new dbhelper(this);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, viewdata.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String name=e1.getText().toString();
            String pass=e2.getText().toString();

            Boolean checkinsert=DB.InsertData(name,pass);

            if(checkinsert==true)
            {
                Toast.makeText(MainActivity.this, "New Entery Inserted ", Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");
            }
            else
            {
                Toast.makeText(MainActivity.this, "Entery Not Inserted ", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }
}