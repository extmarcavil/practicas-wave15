package com.mercadolibre.bootcamp_api_deportistas.repository;

import com.mercadolibre.bootcamp_api_deportistas.entity.Sport;

import java.util.List;

public interface SportRepository {
    List<Sport> getSports();
    Sport getSport(String name);
}
