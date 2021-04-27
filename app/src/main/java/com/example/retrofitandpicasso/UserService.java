package com.example.retrofitandpicasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET("beers/")
    Call<List<UserResponse>> getAllBeers();
}
