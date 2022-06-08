package com.example.uebungmitsql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import java.util.List;

public class aIrgendwosAsync extends AsyncTask<String, Integer, List<Patient>> {
    public aIrgendwosAsync() {
    }

    @Override
    protected List<Patient> doInBackground(String... strings) {

        DemoDBhelper dBhelper= new DemoDBhelper(MainActivity.s1);
        SQLiteDatabase db = dBhelper.getReadableDatabase();
        String vn= "";
        String nn="";

        Cursor rows=db.rawQuery("select Firstname from Patients where id>?",null);

        List<Patient> p1 ;

        return null;
    }
}
