package com.android.studentdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText title_input,author_input,pages_input;
    Button button_input;
    String id,title,author,pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title_input = findViewById(R.id.title2);
        author_input = findViewById(R.id.author2);
        pages_input = findViewById(R.id.pages2);
        button_input = findViewById(R.id.button2);
        button_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        getAndSetIntentData();
    }
       void getAndSetIntentData()
        {
            if(getIntent().hasExtra("id") && getIntent().hasExtra("title")
            && getIntent().hasExtra("author") && getIntent().hasExtra("pages"))
            {
                //getting data from intent
               id=getIntent().getStringExtra("id");
                title=getIntent().getStringExtra("title");
                author=getIntent().getStringExtra("author");
                pages=getIntent().getStringExtra("pages");
               //setting data
                title_input.setText(title);
                author_input.setText(author);
                pages_input.setText(pages);
            }

            else

            {
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
            }
        }
    }
}