package com.bootcamp.jewerly.service;

import com.bootcamp.jewerly.model.Jewel;

import java.util.List;

public interface IJewerlyService {

    public List<Jewel> getJewels();
    public Long saveJewel (Jewel jewel);
    public void deleteJewel (long id);
    public Jewel findJewel (long id);

}
