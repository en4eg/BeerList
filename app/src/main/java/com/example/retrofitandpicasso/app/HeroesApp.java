package com.example.retrofitandpicasso.app;

import android.app.Application;

import com.example.retrofitandpicasso.app.di.AppComponent;
import com.example.retrofitandpicasso.app.di.AppModule;

public class HeroesApp extends Application {
    private static AppComponent mAppComponent;

    public static AppComponent getComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
