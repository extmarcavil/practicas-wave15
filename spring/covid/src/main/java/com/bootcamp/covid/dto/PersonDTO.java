package com.bootcamp.covid.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    Long          id;
    String        name;
    String        lastName;
    Integer          age;
    List<SymptomDTO> symptoms;

    public boolean hasSymptoms () {
        return !this.symptoms.isEmpty();
    }

    @JsonIgnore
    public boolean isOld () {
        return age >= 60;
    }
}
