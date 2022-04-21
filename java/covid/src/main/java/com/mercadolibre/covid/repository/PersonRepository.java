package com.mercadolibre.covid.repository;

import com.mercadolibre.covid.model.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class PersonRepository {

    private List<Person> people;

    @PostConstruct
    private void loadData() {
        people = Stream.of(
                new Person(1L, "Pepe", "Ramirez", 20),
                new Person(2L, "Robert", "Smith", 61),
                new Person(3L, "Emilse", "William", 65),
                new Person(4L, "Julia", "Macieli", 70)
        ).collect(Collectors.toList());
    }

    public List<Person> findAll() {
        return people;
    }

    public void findAllForUpdate(Consumer<Person> callback) {
        findAll().forEach(callback);
    }

}
