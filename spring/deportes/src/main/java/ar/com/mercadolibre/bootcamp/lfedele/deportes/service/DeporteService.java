package ar.com.mercadolibre.bootcamp.lfedele.deportes.service;

import ar.com.mercadolibre.bootcamp.lfedele.deportes.model.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeporteService {
    List<Deporte> deportes = new ArrayList<>();

    public DeporteService() {
        Deporte d1 = new Deporte();
        d1.setNombre("Futbol");
        d1.setNivel(5);

        Deporte d2 = new Deporte();
        d2.setNombre("Tenis");
        d2.setNivel(3);

        Deporte d3 = new Deporte();
        d3.setNombre("Volley");
        d3.setNivel(4);

        this.deportes.add(d1);
        this.deportes.add(d2);
        this.deportes.add(d3);
    }

    public List<Deporte> findAllSports() {
        return this.deportes;
    }

    public Optional<Deporte> findSportByName(String name) {
        return this.deportes
                .stream()
                .filter(d -> d.getNombre().equals(name))
                .findFirst();
    }
}
