package com.daclink.drew.sp22.cst438_project01_starter.api_implementation.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.daclink.drew.sp22.cst438_project01_starter.api_implementation.models.NewsResultsResponse;
import com.daclink.drew.sp22.cst438_project01_starter.api_implementation.repository.NewsRepository;

public class NewsViewModel extends AndroidViewModel {
    private NewsRepository newsRepository;
    private LiveData<NewsResultsResponse> newsResponseLiveData;

    public NewsViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        newsRepository = new NewsRepository();
        newsResponseLiveData = newsRepository.getVolumesResponseLiveData();
    }

    public void searchNews(String keyword, String source, String sortBy) {
        newsRepository.searchNews(keyword, source, sortBy, "22668da3374a4f8885c094cec719ae51");
    }

    public void  searchTopHeadlines(String keyword, String source, String sortBy) {
        newsRepository.searchTopHeadlines(keyword, source, sortBy, "22668da3374a4f8885c094cec719ae51");
    }

    public LiveData<NewsResultsResponse> getVolumesResponseLiveData() {
        return newsResponseLiveData;
    }
}
