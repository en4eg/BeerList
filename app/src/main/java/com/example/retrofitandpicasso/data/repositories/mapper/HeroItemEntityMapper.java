package com.example.retrofitandpicasso.data.repositories.mapper;

import com.example.retrofitandpicasso.data.local.model.HeroItemEntity;
import com.example.retrofitandpicasso.data.repositories.model.HeroItemData;

import java.util.ArrayList;
import java.util.List;

public class HeroItemEntityMapper {
    public static List<HeroItemEntity> create(List<HeroItemData> source) {
        ArrayList<HeroItemEntity> result = new ArrayList<>();
        for (HeroItemData heroDetailData : source) {
            HeroItemEntity heroItemEntity = new HeroItemEntity();
            heroItemEntity.id = heroDetailData.id;
            heroItemEntity.name = heroDetailData.name;
            heroItemEntity.image = heroDetailData.image;
            result.add(heroItemEntity);
        }
        return result;
    }
}
