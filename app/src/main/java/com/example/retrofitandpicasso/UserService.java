package com.example.retrofitandpicasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("api.php/{token}/search/{name}")
    Call<UserResponse> getAllBeers(
            @Path("token") String token,
            @Path("name") String name
    );
}
