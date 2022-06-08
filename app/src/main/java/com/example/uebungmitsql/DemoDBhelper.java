package com.example.uebungmitsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DemoDBhelper extends SQLiteOpenHelper {

private final static String DB_Name = "patient.db";

    public DemoDBhelper(@Nullable Context context) {
        super(context, DB_Name, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(PersonTbl.SQL_CREATE);
    sqLiteDatabase.execSQL(PersonTbl.STMT_INSERT,new String[] {"1","sepp", "berta"});
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(PersonTbl.SQL_DROP);
        sqLiteDatabase.execSQL(PersonTbl.SQL_CREATE);
        sqLiteDatabase.execSQL(PersonTbl.STMT_INSERT,new String[] {"1","sepp", "berta"});
    }
}
