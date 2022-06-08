package com.example.uebungmitsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static  MainActivity s1;
static int x = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       s1=this;

    }



    public void addevent(View view) {

        DemoDBhelper dbhelper = new DemoDBhelper(s1);
        SQLiteDatabase db= dbhelper.getReadableDatabase();
        Cursor row = db.rawQuery("select Firstname from Patients where id="+x,null);
        row.moveToFirst();
        String name= row.getString(0);
        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        x++;

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}