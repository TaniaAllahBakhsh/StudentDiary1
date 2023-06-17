package com.android.studentdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import com.android.studentdiary.MYdatabase;

public class AddActivity extends AppCompatActivity {
    EditText title,author,pages;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        title=findViewById(R.id.title);
        author=findViewById(R.id.author);
        pages=findViewById(R.id.pages);
        add=findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MYdatabase mydb=new MYdatabase(AddActivity.this);
                mydb.addBook(title.getText().toString().trim(),author.getText().toString().trim(),
                        Integer.valueOf(pages.getText().toString().trim()));
            }
        });
    }

}