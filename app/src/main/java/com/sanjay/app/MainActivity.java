package com.sanjay.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton = findViewById(R.id.searchButton);
        EditText searchText = findViewById(R.id.searchEditText);
        // button on click
        searchButton.setOnClickListener(view -> {
            if(!TextUtils.isEmpty(searchText.getText().toString())){
                // api call
                searchMovies(searchText.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(),"Title should not be empty",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void searchMovies(String title) {
        try{
            MovieApiCalls service = MovieClassInstance.getApiInstance().create(MovieApiCalls.class);
            Call<MovieList> call = service.searchMovies("30e9ab74",title.trim());
            call.enqueue(new Callback<MovieList>() {
                @Override
                public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                    if(response.body().getResponse().equals("True")){
                        Toast.makeText(MainActivity.this, "Total movies found = "+response.body().getTotalResults(), Toast.LENGTH_SHORT).show();
                        List<Search> movies = response.body().getSearch();
                        Intent intent = new Intent(MainActivity.this,MovieListAcitivty.class);
                        intent.putExtra("movie_list", (Serializable) movies);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<MovieList> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    Log.e("MAIN:onFailure",t.toString());
                }
            });
        } catch (Exception e){
            Log.e("Exception",e.toString());
            Toast.makeText(this, "Error in search api", Toast.LENGTH_SHORT).show();
        }
    }
}