package com.meli.responseentity.persondto.repository;

import com.meli.responseentity.persondto.model.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class PersonRepository {

    private List<Person> people;

    @PostConstruct
    private void loadData() {
        people = Stream.of(
                new Person(1L, "Pepe", "Ramirez", 20),
                new Person(2L, "Marta", "Enriquez", 19),
                new Person(3L, "Robert", "Williams", 34),
                new Person(4L, "Elmo", "Bush", 45),
                new Person(5L, "Alicia", "Pier", 25)
        ).collect(Collectors.toList());
    }

    public List<Person> findAll() {
        return people;
    }

    public void update(Person person) {
        people.set(Math.toIntExact(person.getId()), person);
    }
}
