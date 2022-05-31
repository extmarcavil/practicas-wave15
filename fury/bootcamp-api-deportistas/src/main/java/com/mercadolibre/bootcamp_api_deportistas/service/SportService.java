package com.mercadolibre.bootcamp_api_deportistas.service;

import com.mercadolibre.bootcamp_api_deportistas.entity.Sport;

import java.util.List;

public interface SportService {
    List<Sport> findSports();
    Sport findSport(String name);
}
