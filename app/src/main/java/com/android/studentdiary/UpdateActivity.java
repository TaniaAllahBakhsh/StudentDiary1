package com.android.studentdiary;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText title_input,author_input,pages_input;
    Button update_input,delete;
    String id,title,author,pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title_input = findViewById(R.id.title2);
        author_input = findViewById(R.id.author2);
        pages_input = findViewById(R.id.pages2);
        update_input = findViewById(R.id.button2);
        delete=findViewById(R.id.button3);
        getAndSetIntentData();

        ActionBar ab=getSupportActionBar();

        assert ab != null;
        ab.setTitle(title);

        update_input.setOnClickListener(view -> {
            //and only then we call this
            MYdatabase db=new MYdatabase(UpdateActivity.this);
            db.updateData(id,title,author,pages);

        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

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

        void confirmDialog()
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Delete " + title + " ?");
            builder.setMessage(("Are you sure want to delete " + title + " ?"));
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    MYdatabase mYdatabase=new MYdatabase(UpdateActivity.this);
                    mYdatabase.deleteOneRow(id);


                }
            });
            builder.setNegativeButton("No ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create().show();
        }
    }
