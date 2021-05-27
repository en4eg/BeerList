package com.example.retrofitandpicasso.domain.mapper;

import com.example.retrofitandpicasso.data.local.model.HeroItemEntity;
import com.example.retrofitandpicasso.data.remote.model.HeroResponse;
import com.example.retrofitandpicasso.data.repositories.model.HeroDetailData;
import com.example.retrofitandpicasso.data.repositories.model.HeroItemData;
import com.example.retrofitandpicasso.domain.model.HeroItemDomain;

import java.util.ArrayList;
import java.util.List;

public class HeroItemDomainMapper {
    public static List<HeroItemDomain> create(List<HeroItemData> source) {
        ArrayList<HeroItemDomain> result = new ArrayList<>();
        for (HeroItemData item : source) {
            result.add(create(item));
        }
        return result;
    }

    public static HeroItemDomain create(HeroItemData source) {
        HeroItemDomain heroItem = new HeroItemDomain();
        heroItem.id = source.id;
        heroItem.name = source.name;
        heroItem.image = source.image;
        return heroItem;
    }
}
