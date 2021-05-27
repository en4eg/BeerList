package com.example.retrofitandpicasso.domain.model;

import com.example.retrofitandpicasso.data.remote.model.HeroDetailResponse;

public class HeroDetailDomain {
    public String name;
    public String id;
    public String image;
    public HeroDetailResponse.Biography biography;
    public HeroDetailResponse.Powerstats powerstats;
}
