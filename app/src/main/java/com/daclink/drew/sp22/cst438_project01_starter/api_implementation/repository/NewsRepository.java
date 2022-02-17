package com.daclink.drew.sp22.cst438_project01_starter.api_implementation.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.daclink.drew.sp22.cst438_project01_starter.api_implementation.apis.NewsSearchService;
import com.daclink.drew.sp22.cst438_project01_starter.api_implementation.models.NewsResultsResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsRepository {
    private static final String NEWS_SEARCH_BASE_URL = "https://newsapi.org/";

    private final NewsSearchService newsSearchService;
    private final MutableLiveData<NewsResultsResponse> newsResponseLiveData;

    public NewsRepository() {
        newsResponseLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        newsSearchService = new retrofit2.Retrofit.Builder()
                .baseUrl(NEWS_SEARCH_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsSearchService.class);

    }

    public void searchNews(String keyword, String author, String sortBy, String apiKey) {
        newsSearchService.searchNews(keyword, author, sortBy, apiKey)
                .enqueue(new Callback<NewsResultsResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<NewsResultsResponse> call, @NonNull Response<NewsResultsResponse> response) {
                        if (response.body() != null) {
                            newsResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<NewsResultsResponse> call, @NonNull Throwable t) {
                        newsResponseLiveData.postValue(null);
                    }
                });
    }

    public void searchTopHeadlines(String keyword, String author, String sortBy, String apiKey) {
        newsSearchService.searchTopHeadlines(keyword, author, sortBy, apiKey)
                .enqueue(new Callback<NewsResultsResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<NewsResultsResponse> call, @NonNull Response<NewsResultsResponse> response) {
                        if (response.body() != null) {
                            newsResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<NewsResultsResponse> call, @NonNull Throwable t) {
                        newsResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData<NewsResultsResponse> getVolumesResponseLiveData() {
        return newsResponseLiveData;
    }
}
