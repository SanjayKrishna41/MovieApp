package com.sanjay.app;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MovieModel implements Serializable {
    @SerializedName("Director")
    private String Director;

    @SerializedName("Title")
    private String Title;

    @SerializedName("Actors")
    private String Actors;

    @SerializedName("Response")
    private String Response;

    @SerializedName("Type")
    private String Type;

    @SerializedName("Year")
    private String Year;

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}
