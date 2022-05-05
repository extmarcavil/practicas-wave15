package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.text.DecimalFormat;
import java.util.List;

public class StudentFactory {


    public static StudentDTO getPedro(){
        StudentDTO studentDTO=new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setSubjects(List.of(
                new SubjectDTO("Matemática",10.),
                new SubjectDTO("Física",10.),
                new SubjectDTO("Química",10.)

        ));
        return studentDTO;
    }

    public static StudentDTO getJuan(){
        StudentDTO studentDTO=new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(
                new SubjectDTO("Matemática",9.),
                new SubjectDTO("Física",6.),
                new SubjectDTO("Química",6.)
        ));
        return studentDTO;
    }


}
