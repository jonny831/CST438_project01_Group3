package com.daclink.drew.sp22.cst438_project01_starter.api_implementation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daclink.drew.sp22.cst438_project01_starter.R;
import com.daclink.drew.sp22.cst438_project01_starter.api_implementation.models.NewsResult;

import java.util.ArrayList;
import java.util.List;

public class NewsResultsAdapter extends RecyclerView.Adapter<NewsResultsAdapter.NewsSearchResultHolder> {
    private List<NewsResult> results = new ArrayList<>();

    @NonNull
    @Override
    public NewsSearchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_result_layout, parent, false);
        return new NewsSearchResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsSearchResultHolder holder, int position) {
        NewsResult newsResult = results.get(position);

        holder.titleTextView.setText(newsResult.getTitle());
        holder.publishedDateTextView.setText(newsResult.getPublicationDate());

        if (newsResult.getImageUrl() != null) {
            String imageUrl = newsResult.getImageUrl()
                    .replace("http://", "https://");

            Glide.with(holder.itemView)
                    .load(imageUrl)
                    .into(holder.thumbnailImageView);
        }

        if (newsResult.getAuthor() != null) {
            holder.authorsTextView.setText(newsResult.getAuthor());
        }

        if(newsResult.getSource() != null) {
            holder.sourceTextView.setText(newsResult.getSource().getName());
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<NewsResult> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class NewsSearchResultHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView sourceTextView;
        private TextView authorsTextView;
        private TextView publishedDateTextView;
        private ImageView thumbnailImageView;

        public NewsSearchResultHolder(@NonNull View itemView) {
            super(itemView);

              titleTextView = itemView.findViewById(R.id.news_title);
              sourceTextView = itemView.findViewById(R.id.news_source);
              authorsTextView = itemView.findViewById(R.id.news_authors);
              publishedDateTextView = itemView.findViewById(R.id.news_publishedDate);
              thumbnailImageView = itemView.findViewById(R.id.thumbnail);
        }
    }
}
