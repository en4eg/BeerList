package com.example.retrofitandpicasso;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        usersAdapter = new UsersAdapter();

        getAllBeer();
    }

    public void getAllBeer() {
        Call<UserResponse> beerList = ApiClient.getUserService().getAllBeers("3882068318495130", "1");
        beerList.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    UserResponse userResponse = response.body();
                    List<UserResponse> responses = new ArrayList<UserResponse>();
                    responses.add(userResponse);
                    usersAdapter.setData(responses);
                    recyclerView.setAdapter(usersAdapter);

                    if (response.body() != null) {
                        Log.e("success", response.body().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }
}
