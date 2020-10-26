package com.brinkley.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.brinkley.booklibrary.database.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FloatingActionButton mAdd_Button;

    DBHelper mDbh;

    CustomAdapter mCustomAdapter;


    ArrayList<String> array_book_id;
    ArrayList<String> array_book_title;
    ArrayList<String> array_book_author;
    ArrayList<String> array_book_pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.Recycler_View);
        mAdd_Button = (FloatingActionButton) findViewById(R.id.Floating_add_button);
        mAdd_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        mDbh = new DBHelper(MainActivity.this);

        array_book_id = new ArrayList<>();
        array_book_title = new ArrayList<>();
        array_book_author = new ArrayList<>();
        array_book_pages = new ArrayList<>();

        writeDataInArray();

        mCustomAdapter = new CustomAdapter(MainActivity.this, array_book_id, array_book_title, array_book_author, array_book_pages);
        mRecyclerView.setAdapter(mCustomAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void writeDataInArray() {
        Cursor cursor = mDbh.readAllData();
        if(cursor.getCount() == 0) {
            Toast.makeText(MainActivity.this, "No items", Toast.LENGTH_SHORT);
        } else {
            while (cursor.moveToNext()) {
                array_book_id.add(cursor.getString(0));
                array_book_title.add(cursor.getString(1));
                array_book_author.add(cursor.getString(2));
                array_book_pages.add(cursor.getString(3));
            }
        }
    }
}