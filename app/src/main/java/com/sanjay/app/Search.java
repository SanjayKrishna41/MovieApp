package com.sanjay.app;

import java.io.Serializable;

public class Search implements Serializable {

    private String Type;

    private String Year;

    private String imdbID;

    private String Poster;

    private String Title;

    public String getType() {
        return this.Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getYear() {
        return this.Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getImdbID() {
        return this.imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return this.Poster;
    }

    public void setPoster(String Poster) {
        this.Poster = Poster;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
}
