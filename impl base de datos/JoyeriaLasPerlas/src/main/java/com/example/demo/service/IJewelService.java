package com.example.demo.service;

import com.example.demo.model.Jewel;
import java.util.List;

public interface IJewelService {

    public List<Jewel> getJewels();
    public Long saveJewel (Jewel jewel);
    public void deleteJewel (long id);
    public Jewel findJewel (long id);
}
