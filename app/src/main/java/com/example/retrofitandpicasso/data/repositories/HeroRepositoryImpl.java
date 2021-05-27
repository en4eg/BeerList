package com.example.retrofitandpicasso.data.repositories;

import com.example.retrofitandpicasso.data.local.HeroDB;
import com.example.retrofitandpicasso.data.local.model.HeroItemEntity;
import com.example.retrofitandpicasso.data.remote.HeroApi;
import com.example.retrofitandpicasso.data.remote.model.HeroDetailResponse;
import com.example.retrofitandpicasso.data.remote.model.HeroResponse;
import com.example.retrofitandpicasso.data.repositories.mapper.HeroDetailDataMapper;
import com.example.retrofitandpicasso.data.repositories.mapper.HeroItemDataMapper;
import com.example.retrofitandpicasso.data.repositories.mapper.HeroItemEntityMapper;
import com.example.retrofitandpicasso.data.repositories.model.HeroDetailData;
import com.example.retrofitandpicasso.data.repositories.model.HeroItemData;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

public class HeroRepositoryImpl implements HeroRepository {
    private static final int LIMIT = 20;
    public static final String TOKEN = "3882068318495130";

    private final HeroDB mHeroDB;
    private final HeroApi mHeroApi;


    @Inject
    public HeroRepositoryImpl(HeroApi heroApi, HeroDB heroDB) {
        mHeroApi = heroApi;
        mHeroDB = heroDB;
    }

    @Override
    public List<HeroItemData> getHeroes() throws IOException {
        List<HeroItemEntity> dbList = mHeroDB.getAll();
        if (dbList.size() > 0) {
            return HeroItemDataMapper.create(dbList);
        } else {
            return updateHeroes();
        }
    }

    @Override
    public List<HeroItemData> updateHeroes() throws IOException {
        try {
            Response<HeroResponse> response = mHeroApi.getAllHeroes(TOKEN, "a").execute();
            List<HeroItemData> list = HeroItemDataMapper.create(response.body());
            List<HeroItemEntity> dbList = HeroItemEntityMapper.create(list);
            mHeroDB.clear();
            mHeroDB.append(dbList);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<HeroItemData> appendHeroes() throws IOException {
        try {
            List<HeroItemData> localHeroes = HeroItemDataMapper.create(mHeroDB.getAll());
            Response<HeroResponse> response = mHeroApi.getAllHeroes(TOKEN, "a").execute();
            List<HeroItemData> remoteHeroes = HeroItemDataMapper.create(response.body());
            mHeroDB.append(HeroItemEntityMapper.create(remoteHeroes));
            localHeroes.addAll(remoteHeroes);
            return localHeroes;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public HeroDetailData getHero(String id) throws IOException {
        try {
            Response<HeroDetailResponse> response = mHeroApi.getHero(TOKEN, id).execute();
            HeroDetailResponse detailResponse = response.body();
            HeroDetailData detailData = HeroDetailDataMapper.create(detailResponse);
            return detailData;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
