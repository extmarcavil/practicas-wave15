package ar.com.mercadolibre.bootcamp.lfedele.covid19.service;

import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Persona;
import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Sintoma;
import ar.com.mercadolibre.bootcamp.lfedele.covid19.repository.ICovidRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CovidService implements ICovidService {
    private final ICovidRepository covidRepository;

    public CovidService(ICovidRepository covidRepository) {
        this.covidRepository = covidRepository;
    }

    @Override
    public List<Sintoma> findAll() {
        return this.covidRepository.findAll();
    }

    @Override
    public Optional<Sintoma> findByName(String name) {
        return this.findAll()
                .stream()
                .filter(s -> s.getNombre().equals(name))
                .findFirst();
    }

    @Override
    public List<Persona> findRiskPerson() {
        return this.covidRepository.personas()
                .stream()
                .filter(Persona::isRiskPerson)
                .collect(Collectors.toList());
    }
}
