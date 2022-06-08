package com.example.uebungmitsql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
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
        List<Patient> p1 = new ArrayList<>();
        Cursor rows=db.rawQuery("select Firstname, Lastname from Patients where id>?",new String[]{"3"});
        while (rows.moveToNext()){
             vn =rows.getString(0);
             nn=rows.getString(1);
            p1.add(new Patient(vn,nn));
        }
        rows.close();
        db.close();
        return p1;
    }
}
