package com.bootcamp.Covid19.dto;

import com.bootcamp.Covid19.model.Symptom;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PersonDTO {
    private String name, surname;
    private List<Symptom> simptoms;

}
