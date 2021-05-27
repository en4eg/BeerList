package com.example.retrofitandpicasso.domain.mapper;

import com.example.retrofitandpicasso.data.repositories.model.HeroDetailData;
import com.example.retrofitandpicasso.domain.model.HeroDetailDomain;

public class HeroDetailDomainMapper {
    public static HeroDetailDomain create(HeroDetailData source) {
        HeroDetailDomain heroData = new HeroDetailDomain();
        heroData.name = source.name;
        heroData.biography = source.biography;
        heroData.powerstats = source.powerstats;
        heroData.image = source.image;
        return heroData;
    }
}
