package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static StudentDTO newStudent(long id, String nombre) {
        List<SubjectDTO> subjects = new ArrayList<>();

        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Lengua", 8.0));

        return new StudentDTO(id, nombre, "", 8.0, subjects);
    }

    public static StudentDTO newGoodStudent(long id, String nombre) {
        List<SubjectDTO> subjects = new ArrayList<>();

        subjects.add(new SubjectDTO("Matematica", 10.0));
        subjects.add(new SubjectDTO("Lengua", 10.0));

        return new StudentDTO(id, nombre, "El alumno " + nombre + " ha obtenido un promedio de 10.00. Felicitaciones!", 10.0, subjects);
    }

    public static StudentDTO newBadStudent(long id, String nombre) {
        List<SubjectDTO> subjects = new ArrayList<>();

        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Lengua", 6.0));

        return new StudentDTO(id, nombre, "El alumno " + nombre + " ha obtenido un promedio de 7.00. Puedes mejorar.", 7.0, subjects);
    }
}
