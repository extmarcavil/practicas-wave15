package com.meli.responseentity.persondto.repository;

import com.meli.responseentity.persondto.exception.SportNotFoundException;
import com.meli.responseentity.persondto.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SportRepository {

    public List<Sport> findAll() {
        return List.of(
            new Sport("football", 2),
            new Sport("volleyball", 3),
            new Sport("basketball", 5),
            new Sport("tennis", 4),
            new Sport("box", 5)
        );
    }

    public List<Sport> findWithLimit(int limit) {
        return findAll().stream().limit(limit)
                .collect(Collectors.toList());
    }

    public Sport findByName(String name) {
        return findAll().stream()
                .filter(sport -> sport.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new SportNotFoundException(name));
    }

}
