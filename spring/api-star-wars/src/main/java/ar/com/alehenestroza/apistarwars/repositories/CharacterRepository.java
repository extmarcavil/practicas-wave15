package ar.com.alehenestroza.apistarwars.repositories;

import ar.com.alehenestroza.apistarwars.models.Character;

import java.util.List;

public interface CharacterRepository {
    List<Character> getAll();
}
