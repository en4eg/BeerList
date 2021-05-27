package com.example.retrofitandpicasso.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeroResponse {
    @SerializedName("results")
    public List<Item> results;

    public static class Item {
        @SerializedName("name")
        public String name;
        @SerializedName("image")
        public Image image;
        @SerializedName("id")
        public String id;

        public static class Image {
            @SerializedName("url")
            public String url;
        }
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "results=" + results +
                '}';
    }
}