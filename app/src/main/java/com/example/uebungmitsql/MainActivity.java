package com.example.uebungmitsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static  MainActivity s1;
    static int x = 1;
    List<Patient> pat;
    ListView lv;
    ArrayAdapter<Patient> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pat=new ArrayList<>();

       s1=this;
       lv = findViewById(R.id.patientLV);
       bindAdapterToListView(lv);


    }
        public void startAsyncTask(View view){
        aIrgendwosAsync ask = new aIrgendwosAsync();
        ask.execute("string");
        pat = ask.doInBackground("string");
        }

        private void bindAdapterToListView(ListView lv){
        mAdapter= new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                pat
        );
        lv.setAdapter(mAdapter);

        }

    public void addevent(View view) {

        DemoDBhelper dbhelper = new DemoDBhelper(s1);
        SQLiteDatabase db= dbhelper.getReadableDatabase();
        Cursor row = db.rawQuery("select Firstname from Patients where id="+x,null);
        row.moveToFirst();
        String name= row.getString(0);
        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        x++;
        mAdapter.notifyDataSetChanged();
        startAsyncTask(view);
        mAdapter.notifyDataSetChanged();

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
}