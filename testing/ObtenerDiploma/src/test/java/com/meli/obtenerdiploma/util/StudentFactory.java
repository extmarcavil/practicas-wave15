package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.Arrays;
import java.util.List;

public class StudentFactory {
    public static StudentDTO createStudent(String name, Double avgScore, String msg, List<SubjectDTO> subjects) {
        StudentDTO s = new StudentDTO();
        s.setStudentName(name);
        s.setAverageScore(avgScore);
        s.setMessage(msg);
        s.setSubjects(subjects);
        return s;
    }

    public static StudentDTO createStraightAStudent() {
        SubjectDTO s1 = SubjectFactory.createSubject("Funcional", 10D);
        SubjectDTO s2 = SubjectFactory.createSubject("Objetos III", 10D);
        StudentDTO s = createStudent("Max Power", 0D, "", Arrays.asList(s1, s2));
        return s;
    }

    public static StudentDTO createLazyStudent() {
        SubjectDTO s1 = SubjectFactory.createSubject("Funcional", 10D);
        SubjectDTO s2 = SubjectFactory.createSubject("Objetos III", 4D);
        StudentDTO s = createStudent("Max Power", 0D, "", Arrays.asList(s1, s2));
        return s;
    }
}
