package com.sanjay.app;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class MovieList implements Serializable {
    private String Response;

    private String totalResults;

    private List<Search> Search;

    public String getResponse() {
        return this.Response;
    }

    public void setResponse(String Response) {
        this.Response = Response;
    }

    public String getTotalResults() {
        return this.totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<Search> getSearch() {
        return this.Search;
    }

    public void setSearch(List<Search> Search) {
        this.Search = Search;
    }
}