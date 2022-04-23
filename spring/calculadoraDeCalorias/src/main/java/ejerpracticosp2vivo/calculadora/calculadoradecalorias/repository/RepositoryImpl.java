package ejerpracticosp2vivo.calculadora.calculadoradecalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ejerpracticosp2vivo.calculadora.calculadoradecalorias.model.Ingrediente;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class RepositoryImpl implements IRepository {
    private Map<String,Ingrediente> database;

    public RepositoryImpl() {
        database=loadDataBase();
    }

    private Map<String,Ingrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS.stream()
                .collect(
                        Collectors.toMap(Ingrediente::getNombre, Function.identity())
                );
    }

    @Override
    public Ingrediente findByName(Ingrediente ingrediente) {
        return database.get(ingrediente.getNombre());
    }
}
