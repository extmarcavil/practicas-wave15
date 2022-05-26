package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDTOFactory {
    public static StudentDTO createStudent(){
        List<SubjectDTO> listaMaterias = new ArrayList<>();
        listaMaterias.add(new SubjectDTO("Matemática",9D));
        listaMaterias.add(new SubjectDTO("Física",9D));
        listaMaterias.add(new SubjectDTO("Química",9D));
        StudentDTO studiant= new StudentDTO();
        studiant.setStudentName("Perico");
        studiant.setId(1L);
        studiant.setSubjects(listaMaterias);

        return studiant;
    }
    public static StudentDTO createStudentWithPromedio(){
        List<SubjectDTO> listaMaterias = new ArrayList<>();
        listaMaterias.add(new SubjectDTO("Matemática",9D));
        listaMaterias.add(new SubjectDTO("Física",9D));
        listaMaterias.add(new SubjectDTO("Química",9D));
        StudentDTO studiant= new StudentDTO();
        studiant.setStudentName("Perico");
        studiant.setId(1L);
        studiant.setAverageScore(9D);
        studiant.setMessage("El alumno Perico ha obtenido un promedio de 9. Puedes mejorar.");
        studiant.setSubjects(listaMaterias);

        return studiant;
    }

}
