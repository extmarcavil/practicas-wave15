package ar.com.alehenestroza.apicovid19.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Symptom {
    private String      code;
    private String      name;
    private int         severity;
}
