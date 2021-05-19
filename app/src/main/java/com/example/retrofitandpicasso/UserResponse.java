package com.example.retrofitandpicasso;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("results")
    public List<Item> results;

    class Item {
        @SerializedName("name")
        public String name;
        @SerializedName("image")
        public Image image;
        @SerializedName("id")
        public String id;

        class Image {
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