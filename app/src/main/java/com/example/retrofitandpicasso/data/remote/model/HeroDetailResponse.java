package com.example.retrofitandpicasso.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class HeroDetailResponse {
    @SerializedName("name")
    public String name;
    @SerializedName("image")
    public Image image;
    @SerializedName("powerstats")
    public Powerstats powerstats;
    @SerializedName("biography")
    public Biography biography;

    public static class Image {
        @SerializedName("url")
        public String url;
    }

    public static class Powerstats {
        @SerializedName("intelligence")
        public String intl;
        @SerializedName("strength")
        public String str;
        @SerializedName("speed")
        public String spd;
        @SerializedName("durability")
        public String dur;
        @SerializedName("power")
        public String pwr;
        @SerializedName("combat")
        public String cbt;
    }

    public static class Biography {
        @SerializedName("publisher")
        public String world;
    }

    @Override
    public String toString() {
        return "DetailUserResponse{" +
                "name='" + name + '\'' +
                ", image=" + image +
                ", powerstats=" + powerstats +
                ", biography=" + biography +
                '}';
    }
}

