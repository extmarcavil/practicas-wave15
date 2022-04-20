package ar.com.mercadolibre.bootcamp.lfedele.deportes.service;

import ar.com.mercadolibre.bootcamp.lfedele.deportes.model.Deporte;
import ar.com.mercadolibre.bootcamp.lfedele.deportes.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {
    private DeporteService deporteService = new DeporteService();

    private List<Persona> personas = new ArrayList<>();

    public PersonaService() {
        List<Deporte> deportes = this.deporteService.findAllSports();

        Persona p1 = new Persona();
        p1.setNombre("Homero");
        p1.setApellido("Thompson");
        p1.setEdad(40);
        p1.addDeporte(deportes.get(0));

        Persona p2 = new Persona();
        p2.setNombre("Max");
        p2.setApellido("Power");
        p2.setEdad(40);
        p2.addDeporte(deportes.get(1));
        p2.addDeporte(deportes.get(2));

        Persona p3 = new Persona();
        p3.setNombre("Cosme");
        p3.setApellido("Fulanito");
        p3.setEdad(40);

        this.personas.add(p1);
        this.personas.add(p2);
        this.personas.add(p3);
    }

    public List<Persona> findSportsPersons() {
        return this.personas
                .stream()
                .filter(p -> p.getDeportes().size() > 0)
                .collect(Collectors.toList());
    }
}
