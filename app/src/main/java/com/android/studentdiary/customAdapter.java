package com.android.studentdiary;

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
    private ArrayList book_id,book_author,book_title,book_page;
  //int position;

    customAdapter(Context context, ArrayList book_id, ArrayList book_author,ArrayList book_page, ArrayList book_title)
    {
        this.context = context;
        this.book_id = book_id;
        this.book_author = book_author;
        this.book_page = book_page;
        this.book_title = book_title;
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
        holder.book_id_text.setText(String.valueOf(book_id.get(position)));
        holder.book_title_text.setText(String.valueOf(book_title.get(position)));
        holder.book_author_text.setText(String.valueOf(book_author.get(position)));
        holder.book_page_text.setText(String.valueOf(book_page.get(position)));

        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int click= holder.getAdapterPosition();
                Intent intent = new Intent(context, UpdateActivity.class);

                intent.putExtra("id", String.valueOf(book_id.get(click)));
                intent.putExtra("title", String.valueOf(book_title.get(click)));
                intent.putExtra("author", String.valueOf(book_author.get(click)));
                intent.putExtra("pages", String.valueOf(book_page.get(click)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {
        TextView book_id_text,book_title_text,book_page_text,book_author_text;
        ConstraintLayout mainlayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_text = itemView.findViewById(R.id.book_id_text);
            book_title_text = itemView.findViewById(R.id.book_title);
            book_author_text = itemView.findViewById(R.id.book_author);
            book_page_text = itemView.findViewById(R.id.book_pages);
            mainlayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
















