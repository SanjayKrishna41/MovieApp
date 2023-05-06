package com.sanjay.app;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieClassInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://www.omdbapi.com/";

    public static Retrofit getApiInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
