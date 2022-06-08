package com.example.uebungmitsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void saveEvent(View view) {
        EditText et1= findViewById(R.id.editTextVN);
        EditText et2= findViewById(R.id.editTextNN);
        DemoDBhelper demoDBhelper = new DemoDBhelper(this);
        SQLiteDatabase db = demoDBhelper.getWritableDatabase();
        db.execSQL(PersonTbl.STMT_INSERT, new String[] {et1.getText().toString(),et2.getText().toString()});

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}