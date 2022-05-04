package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentFactory {

    public static StudentDTO createStudentOne() {
        StudentDTO createStudentOne = new StudentDTO();
        createStudentOne.setId(3L);
        createStudentOne.setStudentName("Marta");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Matemeaticas",8.0);
        SubjectDTO subject2 = new SubjectDTO("Física",9.0);
        SubjectDTO subject3 = new SubjectDTO("Química",10.0);

        subjectDTOList.addAll(Arrays.asList(subject1, subject2, subject3));
        createStudentOne.setSubjects(subjectDTOList);
        return createStudentOne;
    }

    public static StudentDTO createStudentTwo() {
        StudentDTO createStudentTwo = new StudentDTO();
        createStudentTwo.setId(3L);
        createStudentTwo.setStudentName("Martin");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Matemeaticas",6.0);
        SubjectDTO subject2 = new SubjectDTO("Física",7.0);
        SubjectDTO subject3 = new SubjectDTO("Química",8.0);

        subjectDTOList.addAll(Arrays.asList(subject1, subject2, subject3));
        createStudentTwo.setSubjects(subjectDTOList);

        return createStudentTwo;
    }

    public static StudentDTO createStudentThree() {
        StudentDTO createStudentThree = new StudentDTO();
        createStudentThree.setId(3L);
        createStudentThree.setStudentName("Lucia");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Matemeaticas",10.0);
        SubjectDTO subject2 = new SubjectDTO("Física",10.0);
        SubjectDTO subject3 = new SubjectDTO("Química",10.0);

        subjectDTOList.addAll(Arrays.asList(subject1, subject2, subject3));
        createStudentThree.setSubjects(subjectDTOList);
        return createStudentThree;
    }

    public  static StudentDTO getStudentJuanInJson(){
        StudentDTO pedro = new StudentDTO();
        pedro.setId(1L);
        pedro.setStudentName("Juan");
        pedro.setSubjects(Arrays.asList(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0)));
        pedro.setAverageScore(7.3);
        pedro.setMessage("El alumno Juan ha obtenido un promedio de 7.3. Puedes mejorar.");
        return pedro;
    }

    public  static StudentDTO getStudentPedroInJson(){
        StudentDTO pedro = new StudentDTO();
        pedro.setId(2L);
        pedro.setStudentName("Pedro");
        pedro.setSubjects(Arrays.asList(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0), new SubjectDTO("Química", 4.0)));
        return pedro;
    }


}
