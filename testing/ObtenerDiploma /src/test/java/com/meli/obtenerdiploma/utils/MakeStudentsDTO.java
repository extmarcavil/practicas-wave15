package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakeStudentsDTO {

    public static StudentDTO StudentDTOId1(){

        StudentDTO expected = new StudentDTO();
        expected.setId(1L);
        expected.setStudentName("Juan");

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1.setName("Matemática");
        subjectDTO1.setScore(9D);

        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setName("Física");
        subjectDTO2.setScore(7D);

        SubjectDTO subjectDTO3 = new SubjectDTO();
        subjectDTO3.setName("Química");
        subjectDTO3.setScore(6D);

        List<SubjectDTO> subjectDTOList = Arrays.asList(subjectDTO1,subjectDTO2,subjectDTO3);
        expected.setSubjects(subjectDTOList);
        return expected;
    }

    public static StudentDTO StudentDTOId1WhitScore(){

        StudentDTO expected = new StudentDTO();
        expected.setId(1L);
        expected.setStudentName("Juan");

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1.setName("Matemática");
        subjectDTO1.setScore(9D);

        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setName("Física");
        subjectDTO2.setScore(7D);

        SubjectDTO subjectDTO3 = new SubjectDTO();
        subjectDTO3.setName("Química");
        subjectDTO3.setScore(6D);

        List<SubjectDTO> subjectDTOList = Arrays.asList(subjectDTO1,subjectDTO2,subjectDTO3);
        expected.setSubjects(subjectDTOList);

        double average = 7.333333333333333;
        String mensaje = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";

        expected.setAverageScore(average);
        expected.setMessage(mensaje);
        return expected;
    }

    public static StudentDTO StudentDTOId2(){

        StudentDTO expected = new StudentDTO();
        expected.setId(2L);
        expected.setStudentName("Pedro");

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1.setName("Matemática");
        subjectDTO1.setScore(10D);

        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setName("Física");
        subjectDTO2.setScore(8D);

        SubjectDTO subjectDTO3 = new SubjectDTO();
        subjectDTO3.setName("Química");
        subjectDTO3.setScore(4D);

        List<SubjectDTO> subjectDTOList = Arrays.asList(subjectDTO1,subjectDTO2,subjectDTO3);
        expected.setSubjects(subjectDTOList);
        return expected;
    }

    public static StudentDTO StudentDTOId3(){

        StudentDTO expected = new StudentDTO();
        expected.setId(3L);
        expected.setStudentName("Martin");

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1.setName("Matemática");
        subjectDTO1.setScore(9D);

        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setName("Física");
        subjectDTO2.setScore(9D);

        SubjectDTO subjectDTO3 = new SubjectDTO();
        subjectDTO3.setName("Química");
        subjectDTO3.setScore(9D);

        List<SubjectDTO> subjectDTOList = Arrays.asList(subjectDTO1,subjectDTO2,subjectDTO3);
        expected.setSubjects(subjectDTOList);
        return expected;
    }

    public static Set<StudentDTO> getStudentSet(){
        StudentDTO student1 = StudentDTOId1();
        StudentDTO student2 = StudentDTOId2();
        return new HashSet<>(){{add(student1);add(student2);}};
    }
}
