package com.android.studentdiary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder> {
   final private Context context;
   Activity activity;
    private ArrayList student_id,student_name,student_sabaq,student_subqi;
  //int position;

    customAdapter(Activity activity,Context context, ArrayList s_id, ArrayList name,ArrayList sabaq, ArrayList subqi)
    {
        this.activity=activity;
        this.context = context;
        this.student_id = s_id;
        this.student_name = name;
        this.student_sabaq = sabaq;
        this.student_subqi = subqi;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull customAdapter.MyViewHolder holder, int position)
    {
        // position= holder.getAdapterPosition();
        holder.s_id_text.setText(String.valueOf(student_id.get(position)));
        holder.name_text.setText(String.valueOf(student_name.get(position)));
        holder.sabaq_text.setText(String.valueOf(student_sabaq.get(position)));
        holder.sabqi_text.setText(String.valueOf(student_subqi.get(position)));

        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int click= holder.getAdapterPosition();
                Intent intent = new Intent(context, UpdateActivity.class);

                intent.putExtra("id", String.valueOf(student_id.get(click)));
                intent.putExtra("title", String.valueOf(student_name.get(click)));
                intent.putExtra("author", String.valueOf(student_sabaq.get(click)));
                intent.putExtra("pages", String.valueOf(student_subqi.get(click)));
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return student_id.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {
        TextView s_id_text,name_text,sabaq_text,sabqi_text;
        ConstraintLayout mainlayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            s_id_text = itemView.findViewById(R.id.std_id);
            name_text = itemView.findViewById(R.id.sname);
            sabaq_text = itemView.findViewById(R.id.ssabaq);
            sabqi_text = itemView.findViewById(R.id.ssubqi);
            mainlayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
















