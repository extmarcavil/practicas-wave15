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

    /*
    {
    "id":2,
    "studentName":"Pedro",
    "message":null,
    "averageScore":null,
    "subjects":[
        {"name":"Matemática","score":10.0},
        {"name":"Física","score":8.0},
        {"name":"Química","score":4.0}
     ]}
     */

    public static StudentDTO createStudentWithId2() {
        SubjectDTO s1 = SubjectFactory.createSubject("Matemática", 10D);
        SubjectDTO s2 = SubjectFactory.createSubject("Física", 8D);
        SubjectDTO s3 = SubjectFactory.createSubject("Química", 4D);
        StudentDTO s = createStudent("Pedro", null, null, Arrays.asList(s1,s2,s3));
        s.setId(2L);
        return s;
    }
}
