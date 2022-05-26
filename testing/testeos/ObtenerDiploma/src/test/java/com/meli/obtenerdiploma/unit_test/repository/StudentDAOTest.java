package com.meli.obtenerdiploma.unit_test.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {
    private IStudentDAO studentDAO;
    @BeforeEach
    void setup(){
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName(" verificamos si se guarda correctamente un estudiante")
    void saveCorrect(){
        StudentDTO student;
        List<SubjectDTO> listaMaterias = new ArrayList<>();
        listaMaterias.add(new SubjectDTO("Matemática",9D));
        listaMaterias.add(new SubjectDTO("Física",7D));
        listaMaterias.add(new SubjectDTO("Química",6D));
        StudentDTO studiant= new StudentDTO();
        studiant.setStudentName("Juan");
        studiant.setId(1L);
        studiant.setSubjects(listaMaterias);


        studentDAO.save(studiant);


        Assertions.assertTrue(studentDAO.exists(studiant));
    }
    @Test
    @DisplayName(" verificamos si se guarda 2 estudiantes iguales")
    void saveExistsStudentCorrect(){
        StudentDTO student;
        List<SubjectDTO> listaMaterias = new ArrayList<>();
        listaMaterias.add(new SubjectDTO("Matemática",9D));
        listaMaterias.add(new SubjectDTO("Física",7D));
        listaMaterias.add(new SubjectDTO("Química",6D));
        StudentDTO studiant= new StudentDTO();
        studiant.setStudentName("Juan");
        studiant.setId(1L);
        studiant.setSubjects(listaMaterias);


        studentDAO.save(studiant);
        studentDAO.save(studiant);

        Assertions.assertTrue(studentDAO.exists(studiant));

    }

    @Test
    @DisplayName(" verificamos si se borra correctamente un estudiante")
    void deleteCorrect(){
        List<SubjectDTO> listaMaterias = new ArrayList<>();
        listaMaterias.add(new SubjectDTO("Matemática",9D));
        listaMaterias.add(new SubjectDTO("Física",7D));
        listaMaterias.add(new SubjectDTO("Química",6D));
        StudentDTO studiant= new StudentDTO();
        studiant.setStudentName("Juan");
        studiant.setId(1L);
        studiant.setSubjects(listaMaterias);


        studentDAO.save(studiant);
        studentDAO.delete(studiant.getId());


        Assertions.assertFalse(studentDAO.exists(studiant));
    }

    @Test
    @DisplayName(" verificamos si tira excepcion al buscar un estudiante que no existe")
    void findStudentInexist(){
        Long idBuscar=99L;
        List<SubjectDTO> listaMaterias = new ArrayList<>();
        listaMaterias.add(new SubjectDTO("Matemática",9D));
        listaMaterias.add(new SubjectDTO("Física",7D));
        listaMaterias.add(new SubjectDTO("Química",6D));
        StudentDTO studiant= new StudentDTO();
        studiant.setStudentName("Juan");
        studiant.setId(1L);
        studiant.setSubjects(listaMaterias);
        studentDAO.save(studiant);
        Assertions.assertThrows(StudentNotFoundException.class,() ->studentDAO.findById(idBuscar));
    }

    @Test
    @DisplayName(" verificamos buscar un estudiante que si existe correctamente")
    void findStudentCorrecto(){
        List<SubjectDTO> listaMaterias = new ArrayList<>();
        listaMaterias.add(new SubjectDTO("Matemática",9D));
        listaMaterias.add(new SubjectDTO("Física",7D));
        listaMaterias.add(new SubjectDTO("Química",6D));
        StudentDTO studiant= new StudentDTO();
        studiant.setStudentName("Juan");
        studiant.setId(1L);
        studiant.setSubjects(listaMaterias);
        studentDAO.save(studiant);
        Assertions.assertNotNull(studentDAO.findById(studiant.getId()));
    }
}
