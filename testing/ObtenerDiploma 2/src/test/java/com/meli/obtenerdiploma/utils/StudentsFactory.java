package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentsFactory {

    public static List<SubjectDTO> getSubjects() {

        List<SubjectDTO> subjects = new ArrayList<>() {{
            add(new SubjectDTO("Matemática", 10.0));
            add(new SubjectDTO("Física", 8.0));
            add(new SubjectDTO("Química", 4.0));
        }};
        return subjects;
    }

    public static List<SubjectDTO> getSubjectsWithGoodScore() {

        List<SubjectDTO> subjects = new ArrayList<>() {{
            add(new SubjectDTO("Matemática", 10.0));
            add(new SubjectDTO("Física", 10.0));
            add(new SubjectDTO("Química", 10.0));
        }};
        return subjects;
    }
    public static StudentDTO getStudent() {
        StudentDTO student = new StudentDTO();
        student.setId(2L);
        student.setStudentName("Pedro");
        student.setSubjects(getSubjects());
        return student;
    }

    public static StudentDTO getStudentWithHonors() {
        StudentDTO student = new StudentDTO();
        student.setId(4L);
        student.setStudentName("Milena");
        student.setSubjects(getSubjectsWithGoodScore());
        return student;
    }

    public static String getDiplomaMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Puedes mejorar.";
    }

    public static String getDiplomaMessageWithHonors(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Felicitaciones!";
    }
}
