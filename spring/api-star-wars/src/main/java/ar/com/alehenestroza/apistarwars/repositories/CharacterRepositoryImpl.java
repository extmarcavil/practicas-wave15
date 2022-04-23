package ar.com.alehenestroza.apistarwars.repositories;

import ar.com.alehenestroza.apistarwars.models.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
    private final List<Character> characters = loadCharacters();

    @Override
    public List<Character> getAll() {
        return this.characters;
    }

    private List<Character> loadCharacters() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Character>> typeReference = new TypeReference<>() { };
        List<Character> characters = null;
        try {
            characters = mapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
