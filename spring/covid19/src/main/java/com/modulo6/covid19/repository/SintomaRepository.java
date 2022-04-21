package com.modulo6.covid19.repository;

import com.modulo6.covid19.model.PacienteDTO;
import com.modulo6.covid19.model.PersonaDTO;
import com.modulo6.covid19.model.SintomaDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepository {

    List<SintomaDTO> sintomaDTOS = new ArrayList<SintomaDTO>();
    List<PersonaDTO> personaDTOS = new ArrayList<PersonaDTO>();

    public List<SintomaDTO> datosSintomas () {
        SintomaDTO s1 = new SintomaDTO(1L, "fiebre", "grave");
        SintomaDTO s2 = new SintomaDTO(2L, "tos", "medio");
        SintomaDTO s3 = new SintomaDTO(3L, "cansancio", "medio");

        sintomaDTOS.add(s1);
        sintomaDTOS.add(s2);
        sintomaDTOS.add(s3);
        return  sintomaDTOS;
    }

    public List<PersonaDTO> datosPersona () {

        SintomaDTO s1 = new SintomaDTO(1L, "fiebre", "grave");
        SintomaDTO s2 = new SintomaDTO(2L, "tos", "medio");
        SintomaDTO s3 = new SintomaDTO(3L, "cansancio", "medio");

        PersonaDTO p1 = new PersonaDTO(1L, "Juan", "Perez", 34, List.of(s1));
        PersonaDTO p2 = new PersonaDTO(2L, "Jose", "Gomez", 61, List.of(s1));
        PersonaDTO p3 = new PersonaDTO(3L, "Lucia", "Gonzalez", 27, List.of(s3));
        PersonaDTO p4 = new PersonaDTO(4L, "Ana", "Moretti", 80, List.of(s2));


        personaDTOS.add(p1);
        personaDTOS.add(p2);
        personaDTOS.add(p3);
        personaDTOS.add(p4);
        return  personaDTOS;
    }

    public List<SintomaDTO> getAllSintomas() {
        return datosSintomas();
    }

    public List<PersonaDTO> getAllPersonas() {
        return datosPersona();
    }

    public SintomaDTO getFindByName(String name){
        List<SintomaDTO> sintomaDTOS = getAllSintomas();
        SintomaDTO sintomaDTO = new SintomaDTO();

        for (SintomaDTO s : sintomaDTOS) {
            if (s.getNombre().equals(name)) {
                sintomaDTO = s;
            }
        }
        return sintomaDTO;
    }

    public List<PersonaDTO> getPersonasMayores(){
        List<PersonaDTO> personas =  getAllPersonas();
        List<PersonaDTO> personasM =  new ArrayList<PersonaDTO>();

        for (PersonaDTO p : personas) {
            if (p.esMayor()) {
                personasM.add(p);
            }
        }


        return personasM;
    }

}
