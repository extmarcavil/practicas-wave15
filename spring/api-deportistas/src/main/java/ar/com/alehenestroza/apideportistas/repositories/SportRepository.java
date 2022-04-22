package ar.com.alehenestroza.apideportistas.repositories;

import ar.com.alehenestroza.apideportistas.models.Sport;

import java.util.List;

public interface SportRepository {
    List<Sport> getSports();
    Sport getSport(String name);
}
