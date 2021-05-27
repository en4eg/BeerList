package com.example.retrofitandpicasso.domain;

import com.example.retrofitandpicasso.domain.model.HeroDetailDomain;
import com.example.retrofitandpicasso.domain.model.HeroItemDomain;

import java.util.List;

public interface HeroesInteractor {
    void getData(GetDataCallback getDataCallback);

    void refreshData(GetDataCallback getDataCallback);

    void appendData(GetDataCallback getDataCallback);

    void getDataWithFilter(String filter, GetDataCallback getDataCallback);

    void getHero(int id, GetHeroCallback getPokemonCallback);


    interface GetDataCallback {
        void onFinish(List<HeroItemDomain> list);
    }

    interface GetHeroCallback{
        void onFinish(HeroDetailDomain pokemonDomain);
    }
}
