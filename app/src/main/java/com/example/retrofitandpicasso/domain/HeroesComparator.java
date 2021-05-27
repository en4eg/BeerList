package com.example.retrofitandpicasso.domain;

import com.example.retrofitandpicasso.domain.model.HeroItemDomain;

import java.util.Comparator;

public class HeroesComparator implements Comparator<HeroItemDomain> {
    @Override
    public int compare(HeroItemDomain o1, HeroItemDomain o2) {
        int id1 = Integer.parseInt(o1.id);
        int id2 = Integer.parseInt(o2.id);

        if (id1 < id2) {
            return -1;
        } else if (id1 > id2) {
            return 1;
        } else {
            return 0;
        }
    }
}

