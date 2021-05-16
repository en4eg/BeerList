package com.example.retrofitandpicasso;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroDetailActivity extends MainActivity {
    public static final String EXTRA_NUMBER = "EXTRA_NUMBER";
    public static String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);
        number = getIntent().getStringExtra(EXTRA_NUMBER);
        getDetailHero();

        ((androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbarHeroDetail)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void getDetailHero() {
        Call<DetailUserResponse> hero = ApiClient.getUserService().getHero(TOKEN, number);
        hero.enqueue(new Callback<DetailUserResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailUserResponse> call, @NonNull Response<DetailUserResponse> response) {
                if (response.isSuccessful()) {
                    DetailUserResponse detailUserResponse = response.body();
                    ((Toolbar) findViewById(R.id.toolbarHeroDetail)).setTitle(detailUserResponse.name);
                    Picasso.get()
                            .load(detailUserResponse.image.url)
                            .into((ImageView) findViewById(R.id.ImageViewHeroDetail));
                    ((TextView) findViewById(R.id.textViewHeroWorldDetail)).setText(detailUserResponse.biography.world);
                    ((TextView) findViewById(R.id.textViewHeroPowerstatsInt)).setText(detailUserResponse.powerstats.intl);
                    ((TextView) findViewById(R.id.textViewHeroPowerstatsStr)).setText(detailUserResponse.powerstats.str);
                    ((TextView) findViewById(R.id.textViewHeroPowerstatsSpd)).setText(detailUserResponse.powerstats.spd);
                    ((TextView) findViewById(R.id.textViewHeroPowerstatsDur)).setText(detailUserResponse.powerstats.dur);
                    ((TextView) findViewById(R.id.textViewHeroPowerstatsPwr)).setText(detailUserResponse.powerstats.pwr);
                    ((TextView) findViewById(R.id.textViewHeroPowerstatsCbt)).setText(detailUserResponse.powerstats.cbt);
                    if (response.body() != null) {
                        Log.e("success", response.body().toString());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailUserResponse> call, @NonNull Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }
}
