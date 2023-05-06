package com.sanjay.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieListAcitivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list_acitivty);

        Intent i = getIntent();
        List<Search> movies = (List<Search>)  i.getSerializableExtra("movie_list");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movie_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        MovieListAdapter movieListAdapter = new MovieListAdapter(movies);
        recyclerView.setAdapter(movieListAdapter);
    }
}