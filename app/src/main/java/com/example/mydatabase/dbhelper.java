package com.example.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    public dbhelper(@Nullable Context context) {
        super(context,"user.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table sam (name Text,pass Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
    DB.execSQL("drop table if exists sam");
    }

    public boolean InsertData(String name ,String pass)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("pass",pass);

        long res=DB.insert("sam",null,cv);
        if(res==-1)
        {
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getdata()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor c=DB.rawQuery("select * from sam ",null);
        return  c;

    }
}
