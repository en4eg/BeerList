package com.example.retrofitandpicasso.data.repositories.mapper;

import com.example.retrofitandpicasso.data.local.model.HeroItemEntity;
import com.example.retrofitandpicasso.data.remote.model.HeroResponse;
import com.example.retrofitandpicasso.data.repositories.model.HeroItemData;

import java.util.ArrayList;
import java.util.List;

public class HeroItemDataMapper {
    public static List<HeroItemData> create(List<HeroItemEntity> source){
        ArrayList<HeroItemData> result = new ArrayList<>();
        for (HeroItemEntity entity : source){
            HeroItemData heroItemData = new HeroItemData();
            heroItemData.id = entity.id;
            heroItemData.name = entity.name;
            heroItemData.image = entity.image;
            result.add(heroItemData);
        }
        return result;
    }

    public static List<HeroItemData> create(HeroResponse source){
        ArrayList<HeroItemData> result = new ArrayList<>();
        for (HeroResponse.Item item : source.results){
            HeroItemData heroItemData = new HeroItemData();
            heroItemData.id = item.id;
            heroItemData.name = item.name;
            heroItemData.image = item.image;
            result.add(heroItemData);
        }
        return result;
    }
}
