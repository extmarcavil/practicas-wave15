package ar.com.mercadolibre.bootcam.calorias.repository;

import ar.com.mercadolibre.bootcam.calorias.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {
    private List<Plato> platos = new ArrayList<>();

    public PlatoRepositoryImpl(IIngredienteRepository ingredienteRepository) {
        Plato p1 =  new Plato("Milanesa", Arrays.asList(ingredienteRepository.findAll().get(5)));
        Plato p2 = new Plato("El alto plato de los pibes", ingredienteRepository.findAll());
        platos.add(p1);
        platos.add(p2);
    }

    @Override
    public List<Plato> findAll() {
        return platos;
    }
}
