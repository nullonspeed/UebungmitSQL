package com.example.uebungmitsql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
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
        Cursor rows=db.rawQuery("select Firstname and Lastname from Patients where id>?",null);
        while (rows.moveToNext()){
             vn =rows.getString(0);
             nn=rows.getString(1);
            p1.add(new Patient(vn,nn));
        }
        rows.close();
        db.close();

        Toast.makeText(MainActivity.s1, ""+p1.get(1).toString(), Toast.LENGTH_SHORT).show();
        return p1;
    }
}
