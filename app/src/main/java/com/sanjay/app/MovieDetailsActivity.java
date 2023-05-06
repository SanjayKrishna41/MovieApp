package com.sanjay.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsActivity extends AppCompatActivity {
    
    private TextView movieDetails;
    private ImageView moviePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movieDetails = findViewById(R.id.movie_details);
        moviePoster = findViewById(R.id.movie_poster);

        Intent i = getIntent();
        String imdbId = i.getStringExtra("imdb_id");

        getMovieDetails(imdbId);

        Toast.makeText(this, "working "+imdbId, Toast.LENGTH_SHORT).show();
    }

    private void getMovieDetails(String imdbId) {
        try{
            MovieApiCalls service = MovieClassInstance.getApiInstance().create(MovieApiCalls.class);
            Call<MovieDetailsModel> call = service.getMovieDetails("30e9ab74",imdbId.trim());
            call.enqueue(new Callback<MovieDetailsModel>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(Call<MovieDetailsModel> call, Response<MovieDetailsModel> response) {
                    if(response.body().getResponse().equals("True")){
                        MovieDetailsModel movieDetail = response.body();

                        Glide.with(getApplicationContext())
                                .load(movieDetail.getPoster())
                                .placeholder(R.drawable.ic_launcher_background)
                                .into(moviePoster);

                        movieDetails.setText("Title : "+movieDetail.getTitle()+"\n"+
                                             "Year : "+movieDetail.getYear()+"\n"+
                                             "Rated : "+movieDetail.getRated()+"\n"+
                                             "Released : "+movieDetail.getReleased()+"\n"+
                                             "Runtime : "+movieDetail.getRuntime()+"\n"+
                                "Genre : "+movieDetail.getGenre()+"\n"+
                                "Director : "+movieDetail.getDirector()+"\n"+
                                "Actors : "+movieDetail.getActors()+"\n"+
                                "Plot : "+movieDetail.getPlot()+"\n");
                    }

                }

                @Override
                public void onFailure(Call<MovieDetailsModel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    Log.e("MAIN:onFailure",t.toString());
                }
            });
        } catch (Exception e){
            Log.e("Exception",e.toString());
            Toast.makeText(this, "Error in search api", Toast.LENGTH_SHORT).show();
        }
    }
}