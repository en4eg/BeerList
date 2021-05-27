package com.example.retrofitandpicasso.app.di;

import com.example.retrofitandpicasso.data.repositories.HeroRepository;
import com.example.retrofitandpicasso.domain.HeroesInteractor;
import com.example.retrofitandpicasso.domain.HeroesInteractorImpl;

import javax.inject.Singleton;

import dagger.Provides;

public class DomainModule {

//    @Provides
//    public TimerInteractor getTimerInteractor() {
//        return new TimerInteracrotImpl();
//    }
//
    @Provides
    @Singleton
    public HeroesInteractor getHeroesInteractor(HeroRepository heroRepository) {
        return new HeroesInteractorImpl(heroRepository);
    }
}
