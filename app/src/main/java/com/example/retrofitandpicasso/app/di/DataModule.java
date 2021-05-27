package com.example.retrofitandpicasso.app.di;


import com.example.retrofitandpicasso.data.remote.HeroApi;
import com.example.retrofitandpicasso.data.remote.HeroClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    @Singleton
    @Provides
    public HeroApi getHeroesApi(){
        return new HeroClient().getRetrofit().create(HeroApi.class);
    }
}
