package com.daclink.drew.sp22.cst438_project01_starter.api_implementation.apis;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.daclink.drew.sp22.cst438_project01_starter.api_implementation.models.NewsResultsResponse;

public interface NewsSearchService {
    @GET("/v2/everything")
    Call<NewsResultsResponse> searchNews(
            @Query("q") String query,
            @Query("sources") String sources,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );

    @GET("/v2/top-headlines")
    Call<NewsResultsResponse> searchTopHeadlines(
            @Query("q") String query,
            @Query("sources") String sources,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );
}
