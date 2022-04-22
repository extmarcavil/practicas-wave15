package ar.com.alehenestroza.apicovid19.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Person {
    private Integer         id;
    private String          name;
    private String          surname;
    private List<Symptom>   symptoms;
    private int             age;

    public Person(Integer id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.symptoms = new ArrayList<>();
    }

    public void addSymptom(Symptom symptom) {
        this.symptoms.add(symptom);
    }
}
