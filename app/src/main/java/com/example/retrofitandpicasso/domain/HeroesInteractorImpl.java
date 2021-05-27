package com.example.retrofitandpicasso.domain;

import com.example.retrofitandpicasso.data.repositories.HeroRepository;
import com.example.retrofitandpicasso.data.repositories.mapper.HeroDetailDataMapper;
import com.example.retrofitandpicasso.data.repositories.model.HeroDetailData;
import com.example.retrofitandpicasso.data.repositories.model.HeroItemData;
import com.example.retrofitandpicasso.domain.mapper.HeroDetailDomainMapper;
import com.example.retrofitandpicasso.domain.mapper.HeroItemDomainMapper;
import com.example.retrofitandpicasso.domain.model.HeroDetailDomain;
import com.example.retrofitandpicasso.domain.model.HeroItemDomain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class HeroesInteractorImpl implements HeroesInteractor {
    private final HeroRepository mHeroesRepository;

    @Inject
    public HeroesInteractorImpl(HeroRepository heroRepository) {
        mHeroesRepository = heroRepository;
    }

    @Override
    public void getData(GetDataCallback getDataCallback) {
        new Thread() {
            @Override
            public void run() {
                List<HeroItemDomain> list;
                try {
                    List<HeroItemData> heroes = mHeroesRepository.getHeroes();
                    list = HeroItemDomainMapper.create(heroes);
                } catch (IOException e) {
                    e.printStackTrace();
                    list = new ArrayList<>();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    list = new ArrayList<>();
                }
                Collections.sort(list, new HeroesComparator());
                getDataCallback.onFinish(list);
            }
        }.start();
    }

    @Override
    public void refreshData(GetDataCallback getDataCallback) {
        new Thread() {
            @Override
            public void run() {
                List<HeroItemDomain> list;
                try {
                    List<HeroItemData> heroes = mHeroesRepository.updateHeroes();
                    list = HeroItemDomainMapper.create(heroes);
                } catch (IOException e) {
                    e.printStackTrace();
                    list = new ArrayList<>();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    list = new ArrayList<>();
                }
                Collections.sort(list, new HeroesComparator());
                getDataCallback.onFinish(list);
            }
        }.start();
    }

    @Override
    public void appendData(GetDataCallback getDataCallback) {
        new Thread() {
            @Override
            public void run() {
                List<HeroItemDomain> list;
                try {
                    List<HeroItemData> pokemons = mHeroesRepository.appendHeroes();
                    list = HeroItemDomainMapper.create(pokemons);
                } catch (Exception e) {
                    e.printStackTrace();
                    list = new ArrayList<>();
                }
                Collections.sort(list, new HeroesComparator());
                getDataCallback.onFinish(list);
            }
        }.start();
    }

    @Override
    public void getDataWithFilter(String filter, GetDataCallback getDataCallback) {
        new Thread() {
            @Override
            public void run() {
                List<HeroItemDomain> list = new ArrayList<>();
                try {
                    List<HeroItemData> pokemons = mHeroesRepository.getHeroes();
                    for (HeroItemData item : pokemons) {
                        if (item.name.contains(filter)) {
                            list.add(HeroItemDomainMapper.create(item));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    list = new ArrayList<>();
                }
                Collections.sort(list, new HeroesComparator());
                getDataCallback.onFinish(list);
            }
        }.start();
    }

    @Override
    public void getHero(int id, GetHeroCallback getHeroCallback) {
        new Thread(){
            @Override
            public void run() {
                HeroDetailDomain heroDetailDomain;
                try {
                    HeroDetailData heroDetailData = mHeroesRepository.getHero(String.valueOf(id));
                    heroDetailDomain = HeroDetailDomainMapper.create(heroDetailData);
                } catch (IOException e) {
                    e.printStackTrace();
                    heroDetailDomain = null;
                }
                getHeroCallback.onFinish(heroDetailDomain);
            }
        }.start();
    }
}
