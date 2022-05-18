package com.bootcamp.jewelry.service;

import com.bootcamp.jewelry.dto.ReqJewelDTO;
import com.bootcamp.jewelry.dto.ResJewlDTO;

import java.util.List;

public interface IJewelryService {

    public List<ResJewlDTO> getJewels();
    public Long saveJewel (ReqJewelDTO jewelDTO);
    public void deleteJewel (long id);
    public ResJewlDTO updateJewel (long id_modify, ReqJewelDTO jewelDTO);
    public ResJewlDTO findJewel (long id);
}
