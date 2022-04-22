package ar.com.alehenestroza.apideportistas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private String  name;
    private String  surname;
    private String  sportName;
    private int     age;
}
