package com.example.deportistas.repository;

import com.example.deportistas.model.Person;

import java.util.ArrayList;

public class PersonRepository {
    private int index = 0;
    private ArrayList<Person> personas = new ArrayList<>();

    public PersonRepository(){
        AddPerson(new Person("Rodrigo","Gomez",28));
        AddPerson(new Person("Alan","Brito",20));
        AddPerson(new Person("Susana","Horia",30));
    }

    public boolean AddPerson(Person person){
        person.setId(index++ + "");

        personas.add(person);
        return true;
    }

    public ArrayList<Person> getPersonas() {
        return personas;
    }

    public Person getById(String id){
        return personas
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
