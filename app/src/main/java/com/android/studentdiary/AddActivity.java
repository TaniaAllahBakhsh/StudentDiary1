package com.android.studentdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddActivity extends AppCompatActivity {
    EditText name,sb,sbki;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name=findViewById(R.id.StudentName);
        sb=findViewById(R.id.Sabak);
        sbki=findViewById(R.id.Subki);
        add=findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MYdatabase my_db=new MYdatabase(AddActivity.this);
                my_db.addBook(name.getText().toString().trim(),sb.getText().toString().trim(),
                        Integer.valueOf(sbki.getText().toString().trim()));
            }
        });
    }

}