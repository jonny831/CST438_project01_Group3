package com.daclink.drew.sp22.cst438_project01_starter.api_implementation.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsResultSource {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
