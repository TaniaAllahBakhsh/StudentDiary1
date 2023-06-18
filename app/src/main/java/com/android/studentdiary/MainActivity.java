package com.android.studentdiary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton floatAction;
    MYdatabase myDb;
    ArrayList<String> student_id,student_name,sabak,subki;
    customAdapter CustomAdapter;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0)
        {
            recreate();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleview);
        floatAction=findViewById(R.id.floatingAction);
        floatAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });
          myDb=new MYdatabase(MainActivity.this);
          student_id=new ArrayList<>();
          student_name=new ArrayList<>();
          sabak=new ArrayList<>();
          subki=new ArrayList<>();
        storeDataInArray();
        CustomAdapter=new customAdapter(MainActivity.this, this, student_id,student_name,sabak,subki);
        recyclerView.setAdapter(CustomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
    void storeDataInArray()
    {
        Cursor cursor=myDb.readAllData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                student_id.add(cursor.getString(0));
                student_name.add(cursor.getString(1));
                sabak.add(cursor.getString(2));
                subki.add(cursor.getString(3));

            }
        }
    }
}
