package com.example.retrofitandpicasso.app.di;


import android.app.ListActivity;

import com.example.retrofitandpicasso.HeroDetailActivity;
import com.example.retrofitandpicasso.SplashActivity;
import com.example.retrofitandpicasso.HeroListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, DomainModule.class})
public interface AppComponent {
    void inject(SplashActivity splashActivity);
    void inject(HeroListActivity heroListActivity);
    void inject(HeroDetailActivity heroDetailActivity);
}
