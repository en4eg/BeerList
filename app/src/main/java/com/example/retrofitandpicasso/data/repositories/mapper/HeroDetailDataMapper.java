package com.example.retrofitandpicasso.data.repositories.mapper;

import com.example.retrofitandpicasso.data.remote.model.HeroDetailResponse;
import com.example.retrofitandpicasso.data.repositories.model.HeroDetailData;

public class HeroDetailDataMapper {
    public static HeroDetailData create(HeroDetailResponse source){
        HeroDetailData heroDetailData = new HeroDetailData();
        heroDetailData.name = source.name;
        heroDetailData.image = source.image.url;
        heroDetailData.powerstats = source.powerstats;
        heroDetailData.biography = source.biography;

        return heroDetailData;
    }
}
