package ar.com.alehenestroza.apideportistas.services;

import ar.com.alehenestroza.apideportistas.models.Sport;

import java.util.List;

public interface SportService {
    List<Sport> findSports();
    Sport findSport(String name);
}
