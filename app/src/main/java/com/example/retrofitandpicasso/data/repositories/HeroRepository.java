package com.example.retrofitandpicasso.data.repositories;

import com.example.retrofitandpicasso.data.repositories.model.HeroDetailData;
import com.example.retrofitandpicasso.data.repositories.model.HeroItemData;

import java.io.IOException;
import java.util.List;

public interface HeroRepository {
    List<HeroItemData> getHeroes() throws IOException;
    List<HeroItemData> updateHeroes() throws IOException;
    List<HeroItemData> appendHeroes() throws IOException;
    HeroDetailData getHero(String id) throws IOException;
}
