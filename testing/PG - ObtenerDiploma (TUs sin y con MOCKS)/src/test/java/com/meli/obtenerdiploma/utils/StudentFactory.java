package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.Arrays;
import java.util.List;

public class StudentFactory {

    public static StudentDTO createJuan(){
        SubjectDTO matematica = SubjectFactory.getMatematica();

        SubjectDTO fisica = SubjectFactory.getFisica();

        SubjectDTO quimica = SubjectFactory.getQuimica();

        List<SubjectDTO> subjects = Arrays.asList(matematica, fisica, quimica);

        StudentDTO expected = new StudentDTO();
        expected.setId(1L);
        expected.setStudentName("Juan");
        expected.setSubjects(subjects);

        return expected;
    }

    public static StudentDTO createPedro(){
        SubjectDTO lengua = SubjectFactory.getLengua();

        List<SubjectDTO> subjects = Arrays.asList(lengua);

        StudentDTO expected = new StudentDTO();
        expected.setId(2L);
        expected.setStudentName("Pedro");
        expected.setSubjects(subjects);

        return expected;
    }
}
