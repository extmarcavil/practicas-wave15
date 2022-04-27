package com.meli.startwars.repository;

import com.meli.startwars.model.CharacterEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterRepository {

    public List<CharacterEntity> findAll() {
        return List.of(
                new CharacterEntity("Pepe", 2, 3, "Black", "Red", "Black",
                        "1992", "M", "Earth", "nothing"),

                new CharacterEntity("Darth Maul", 5, 44, "Black", "Black", "Black",
                        "3223", "S", "Earth", "nothing"),

                new CharacterEntity("Darth Vader", 32, 3, "Black", "Red", "Black",
                        "1992", "M", "Earth", "nothing"),

                new CharacterEntity("Luke Skywalker", 15, 3, "Black", "Red", "Black",
                        "1992", "M", "Earth", "nothing"),

                new CharacterEntity("Yoda", 2, 50, "Green", "Green", "Green",
                        "999", "P", "Jupiter", "nothing")
        );
    }
}
