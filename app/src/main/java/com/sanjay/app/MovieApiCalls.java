package com.sanjay.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiCalls {

    @GET("?")
    Call<MovieList> searchMovies(
            @Query("apikey") String apiKey,
            @Query("s") String title
    );

    @GET("?")
    Call<MovieDetailsModel> getMovieDetails(
            @Query("apikey") String apiKey,
            @Query("i") String imdbId
    );
}
