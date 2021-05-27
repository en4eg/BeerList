package com.example.retrofitandpicasso.data.remote;

import com.example.retrofitandpicasso.data.remote.model.HeroDetailResponse;
import com.example.retrofitandpicasso.data.remote.model.HeroResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HeroApi {
    @GET("api.php/{token}/search/{name}")
    Call<HeroResponse> getAllHeroes(
            @Path("token") String token,
            @Path("name") String name
    );

    @GET("api.php/{token}/{id}")
    Call<HeroDetailResponse> getHero(
            @Path("token") String token,
            @Path("id") String id
    );
}
