package ar.com.mercadolibre.bootcam.calorias.repository;

import ar.com.mercadolibre.bootcam.calorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredienteRepositoryImpl implements IngredienteRepository {

    //Lista de platos Bd.
    private final List<Ingrediente> database;

    public IngredienteRepositoryImpl() {
        this.database = loadDataBase();
    }


    /**
     * Metodos
     *
     * @return
     */
    @Override
    public List<Ingrediente> findAll() {
        return this.database;
    }

    private List<Ingrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};

        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }
}
