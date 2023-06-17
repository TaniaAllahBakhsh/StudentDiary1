package com.android.studentdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText title_input,author_input,pages_input;
    Button button_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title_input=findViewById(R.id.title2);
        author_input=findViewById(R.id.author2);
        pages_input=findViewById(R.id.pages2);
        button_input=findViewById(R.id.button2);

    }
}