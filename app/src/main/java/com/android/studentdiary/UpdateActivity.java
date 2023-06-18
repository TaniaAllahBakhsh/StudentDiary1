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
    EditText name_input,sabaq_input,subqi_input;
    Button update_input,delete;
    String id,name,sabaq,sabqi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name_input = findViewById(R.id.name2);
        sabaq_input = findViewById(R.id.sabaq2);
        subqi_input = findViewById(R.id.sabqi2);
        update_input = findViewById(R.id.button2);
        delete=findViewById(R.id.button3);
        getAndSetIntentData();

        ActionBar ab=getSupportActionBar();

        assert ab != null;
        ab.setTitle(name);

        update_input.setOnClickListener(view -> {
            //and only then we call this
            MYdatabase db=new MYdatabase(UpdateActivity.this);
            db.updateData(id,name,sabaq,sabqi);

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
                name=getIntent().getStringExtra("title");
                sabaq=getIntent().getStringExtra("author");
                sabqi=getIntent().getStringExtra("pages");
               //setting data
                name_input.setText(name);
                sabaq_input.setText(sabaq);
                subqi_input.setText(sabqi);
            }

            else

            {
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
            }
        }

        void confirmDialog()
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Delete " + name + " ?");
            builder.setMessage(("Are you sure want to delete " + name + " ?"));
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
