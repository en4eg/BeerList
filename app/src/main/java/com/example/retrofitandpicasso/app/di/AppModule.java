package com.example.retrofitandpicasso.app.di;

import android.content.Context;

import dagger.Provides;

public class AppModule {
    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    public Context getContext(){
        return mContext;
    }
}
