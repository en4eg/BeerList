package com.example.retrofitandpicasso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TOKEN = "3882068318495130";
    public static final String EXTRA_SYMBOL = "EXTRA_SYMBOL";
    public static String symbol;

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
        symbol = getIntent().getStringExtra(EXTRA_SYMBOL);
        getAllHeroes();
        usersAdapter.setListener(new UsersAdapter.OnClickListener() {
            @Override
            public void onClick(UserResponse.Item item) {
                Intent intent = new Intent(MainActivity.this, HeroDetailActivity.class);
                intent.putExtra(HeroDetailActivity.EXTRA_NUMBER, item.id);
                startActivity(intent);
            }
        });
    }

    public void getAllHeroes() {
        Call<UserResponse> heroesList = ApiClient.getUserService().getAllHeroes(TOKEN, symbol);
        heroesList.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    List<UserResponse.Item> userResponse = null;
                    if (response.body() != null) {
                        userResponse = response.body().results;
                    }
                    usersAdapter.setData(userResponse);
                    recyclerView.setAdapter(usersAdapter);

                    if (response.body() != null) {
                        Log.e("success", response.body().toString());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }
}
