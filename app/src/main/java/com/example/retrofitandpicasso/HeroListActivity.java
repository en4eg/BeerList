package com.example.retrofitandpicasso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitandpicasso.data.remote.HeroClient;
import com.example.retrofitandpicasso.data.remote.model.HeroResponse;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroListActivity extends AppCompatActivity {
    public static final String TOKEN = "3882068318495130";
    private Timer mTimer = null;
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
        getAllHeroes();
        usersAdapter.setListener(new UsersAdapter.OnClickListener() {
            @Override
            public void onClick(HeroResponse.Item item) {
                Intent intent = new Intent(HeroListActivity.this, HeroDetailActivity.class);
                intent.putExtra(HeroDetailActivity.EXTRA_NUMBER, item.id);
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarList);
        Menu menu = toolbar.getMenu();
        MenuItem searchMenuItem = menu.findItem(R.id.mi_list_search);
        SearchView searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (mTimer != null) {
                    mTimer.cancel();
                }
                mTimer = new Timer();
                mTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mTimer = null;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                usersAdapter.setFilter(newText);
                                usersAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }, 5);
                return false;
            }
        });
    }

    public void getAllHeroes() {
        Call<HeroResponse> heroesList = HeroClient.getUserService().getAllHeroes(TOKEN, "a");
        heroesList.enqueue(new Callback<HeroResponse>() {
            @Override
            public void onResponse(@NonNull Call<HeroResponse> call, @NonNull Response<HeroResponse> response) {
                if (response.isSuccessful()) {
                    List<HeroResponse.Item> userResponse = response.body().results;
                    usersAdapter.setData(userResponse);
                    recyclerView.setAdapter(usersAdapter);
                    if (response.body() != null) {
                        Log.e("success", response.body().toString());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<HeroResponse> call, @NonNull Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }
}
