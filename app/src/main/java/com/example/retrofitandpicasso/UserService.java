package com.example.retrofitandpicasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("api.php/{token}/search/{name}")
    Call<UserResponse> getAllHeroes(
            @Path("token") String token,
            @Path("name") String name
    );

    @GET("api.php/{token}/{id}")
    Call<DetailUserResponse> getHero(
            @Path("token") String token,
            @Path("id") String id
    );
}
