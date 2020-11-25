package com.brinkley.booklibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context mContext;

    ArrayList<String> array_book_id;
    ArrayList<String> array_book_title;
    ArrayList<String> array_book_author;
    ArrayList<String> array_book_pages;

    CustomAdapter(Context mContext,
                  ArrayList<String> array_book_id,
                  ArrayList<String> array_book_title,
                  ArrayList<String> array_book_author,
                  ArrayList<String> array_book_pages) {
        this.mContext = mContext;
        this.array_book_id = array_book_id;
        this.array_book_title = array_book_title;
        this.array_book_author = array_book_author;
        this.array_book_pages = array_book_pages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.book_id_text.setText(String.valueOf(array_book_id.get(position)));
        holder.book_title_text.setText(String.valueOf(array_book_title.get(position)));
        holder.book_author_text.setText(String.valueOf(array_book_author.get(position)));
        holder.book_pages_text.setText(String.valueOf(array_book_pages.get(position)));
    }

    @Override
    public int getItemCount() {
        return array_book_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView book_id_text;
        TextView book_title_text;
        TextView book_author_text;
        TextView book_pages_text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            book_id_text = (TextView) itemView.findViewById(R.id.book_id_text);
            book_title_text = (TextView) itemView.findViewById(R.id.book_title_text);
            book_author_text = (TextView) itemView.findViewById(R.id.book_author_text);
            book_pages_text = (TextView) itemView.findViewById(R.id.book_pages_text);
        }
    }
}
