package searcher.covid.model;

import searcher.covid.dto.MappeableToDTO;
import searcher.covid.dto.PersonDTO;

import java.util.ArrayList;
import java.util.List;

public class Person implements MappeableToDTO<PersonDTO> {

    private int id;
    private String name;
    private String surname;
    private int age;
    private ArrayList<Symptom> listOfSymptoms;

    private Person(int id,String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public static Person newPerson(int id, String name, String surname, int age) {
        Person aPerson = new Person(id,name,surname,age);
        aPerson.listOfSymptoms = new ArrayList<>();
        return aPerson;
    }

    public static Person newPersonWithSymptoms(int id, String name, String surname, int age, List<Symptom> listOfSymptom) {
        Person aPerson = new Person(id,name,surname,age);
        aPerson.listOfSymptoms = new ArrayList<>(listOfSymptom);
        return aPerson;
    }

    public boolean isOldAge(){
        return this.age > 60;
    }

    public boolean hasSymptoms(){
        return this.listOfSymptoms.size() > 1;
    }


    @Override
    public void mapToDTO(PersonDTO aDTO) {
        aDTO.setID(id);
        aDTO.setName(name);
        aDTO.setSurname(surname);
        aDTO.setAge(age);
    }
}
