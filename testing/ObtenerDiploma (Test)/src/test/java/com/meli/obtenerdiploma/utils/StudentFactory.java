package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class StudentFactory {

    public static StudentDTO studentJuan() {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9D);
        SubjectDTO subject2 = new SubjectDTO("Física", 7D);
        SubjectDTO subject3 = new SubjectDTO("Química", 6D);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2, subject3);
        StudentDTO student = new StudentDTO(1L, "Juan", subjects);

        return student;
    }

    public static StudentDTO studentJuanWithScores() {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9D);
        SubjectDTO subject2 = new SubjectDTO("Física", 7D);
        SubjectDTO subject3 = new SubjectDTO("Química", 6D);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2, subject3);
        String message = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";
        StudentDTO student = new StudentDTO(1L, "Juan", message, 7.33, subjects);

        return student;
    }

    public static StudentDTO studentPedro() {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 10D);
        SubjectDTO subject2 = new SubjectDTO("Física", 8D);
        SubjectDTO subject3 = new SubjectDTO("Química", 4D);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2, subject3);
        StudentDTO student = new StudentDTO(2L, "Pedro", subjects);

        return student;
    }

    public static StudentDTO studentMaria() {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9D);
        SubjectDTO subject2 = new SubjectDTO("Física", 7D);
        SubjectDTO subject3 = new SubjectDTO("Química", 6D);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2, subject3);
        StudentDTO student = new StudentDTO(3L, "María", subjects);

        return student;
    }

    public static StudentDTO studentPedroModified() {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 10D);
        SubjectDTO subject2 = new SubjectDTO("Física", 8D);
        SubjectDTO subject3 = new SubjectDTO("Química", 8D);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2, subject3);
        StudentDTO student = new StudentDTO(2L, "Pedro", subjects);

        return student;
    }
}
