package com.example.retrofitandpicasso.data.local;

import com.example.retrofitandpicasso.data.local.model.HeroItemEntity;

import java.util.List;

public interface HeroDB {
    List<HeroItemEntity> getAll();
    void append(List<HeroItemEntity> list);
    void clear();
}
