package com.example.retrofitandpicasso.data.remote;

import com.example.retrofitandpicasso.data.remote.HeroApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroClient {
     public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.superheroapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static HeroApi getUserService() {
        HeroApi heroApi = getRetrofit().create(HeroApi.class);
        return heroApi;
    }
}
