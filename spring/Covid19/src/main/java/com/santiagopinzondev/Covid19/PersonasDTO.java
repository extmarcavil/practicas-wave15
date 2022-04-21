package com.santiagopinzondev.Covid19;

import java.util.ArrayList;
import java.util.List;

public class PersonasDTO {
    private static List<PersonaSintomaDTO> personas = new ArrayList<>();

    public static void addPersona(PersonaSintomaDTO person){
        personas.add(person);
    }

    public static List<PersonaSintomaDTO> getPersonas() {
        return personas;
    }

    public static void setPersonas(List<PersonaSintomaDTO> personas) {
        PersonasDTO.personas = personas;
    }
}
