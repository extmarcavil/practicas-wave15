package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.*;

public class StudentFactory {

    public static StudentDTO createStudent() {
        List<SubjectDTO> pedroSubjects = new ArrayList<>();
        pedroSubjects.add(new SubjectDTO("Matemática", 2.0));
        pedroSubjects.add(new SubjectDTO("Física", 8.0));
        pedroSubjects.add(new SubjectDTO("Química", 4.0));
        StudentDTO pedro = new StudentDTO(1L, "Pedro", null, null, pedroSubjects);

        return pedro;
    }

    public static StudentDTO createStudent2() {
        List<SubjectDTO> juanSubjects = new ArrayList<>();
        juanSubjects.add(new SubjectDTO("Matemática", 10.0));
        juanSubjects.add(new SubjectDTO("Física", 8.0));
        juanSubjects.add(new SubjectDTO("Química", 10.0));
        StudentDTO juan = new StudentDTO(2L, "Juan", null, null, juanSubjects);

        return juan;
    }

    public static StudentDTO getStudentWithAverageScore() {
        String message = "El alumno Pedro ha obtenido un promedio de 4.67. Puedes mejorar.";

        List<SubjectDTO> pedroSubjects = new ArrayList<>();
        pedroSubjects.add(new SubjectDTO("Matemática", 2.0));
        pedroSubjects.add(new SubjectDTO("Física", 8.0));
        pedroSubjects.add(new SubjectDTO("Química", 4.0));
        StudentDTO pedro = new StudentDTO(1L, "Pedro", message, (2+8+4)/3D, pedroSubjects);

        return pedro;
    }

    public static Set<StudentDTO> getAllStudents() {
        Set<StudentDTO> students = new HashSet<>();

        List<SubjectDTO> pedroSubjects = new ArrayList<>();
        pedroSubjects.add(new SubjectDTO("Matemática", 2.0));
        pedroSubjects.add(new SubjectDTO("Física", 8.0));
        pedroSubjects.add(new SubjectDTO("Química", 4.0));
        StudentDTO pedro = new StudentDTO(1L, "Pedro", null, null, pedroSubjects);

        students.add(pedro);

        List<SubjectDTO> juanSubjects = new ArrayList<>();
        juanSubjects.add(new SubjectDTO("Matemática", 10.0));
        juanSubjects.add(new SubjectDTO("Física", 6.0));
        juanSubjects.add(new SubjectDTO("Química", 7.0));
        StudentDTO juan = new StudentDTO(2L, "Juan", null, null, juanSubjects);

        students.add(juan);

        return students;
    }
}
