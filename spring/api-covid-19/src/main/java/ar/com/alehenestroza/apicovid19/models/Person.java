package ar.com.alehenestroza.apicovid19.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private Integer     id;
    private String      name;
    private String      surname;
    private int         age;
}
