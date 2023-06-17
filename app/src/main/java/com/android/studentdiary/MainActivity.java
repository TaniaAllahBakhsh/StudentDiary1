package com.android.studentdiary;

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
    ArrayList<String> book_id,book_title,book_author,book_pages;
    customAdapter CustomAdapter;
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
          book_id=new ArrayList<>();
          book_author=new ArrayList<>();
          book_pages=new ArrayList<>();
          book_title=new ArrayList<>();
        storeDataInArray();
        CustomAdapter=new customAdapter(MainActivity.this,book_id,book_author,book_pages,book_title);
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
                book_id.add(cursor.getString(0));
                book_title.add(cursor.getString(1));
                book_author.add(cursor.getString(2));
                book_pages.add(cursor.getString(3));

            }
        }
    }
}
