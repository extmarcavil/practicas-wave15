package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    IStudentDAO dao;

    @BeforeEach
    void setup(){
        dao = new StudentDAO();
    }

    @Test
    @DisplayName("guardar un estudiante")
    void saveTest() {
        List<SubjectDTO> carlaSubjects = new ArrayList<>();
        carlaSubjects.add(new SubjectDTO("Matemática", 9.0));
        carlaSubjects.add(new SubjectDTO("Física", 7.0));
        carlaSubjects.add(new SubjectDTO("Química", 6.0));
        StudentDTO carla = new StudentDTO(3L, "Carla", null, null, carlaSubjects);

        dao.save(carla);

        assertTrue(dao.exists(carla));
    }

    @Test
    @DisplayName("eliminar un estudiante")
    void deleteTest() {
        dao.delete(1L);
        assertThrows(StudentNotFoundException.class, () -> dao.findById(1L));
    }

    @Test
    @DisplayName("chequeo si existe un estudiante")
    void existsTest() {
        List<SubjectDTO> carlaSubjects = new ArrayList<>();
        carlaSubjects.add(new SubjectDTO("Matemática", 9.0));
        carlaSubjects.add(new SubjectDTO("Física", 7.0));
        carlaSubjects.add(new SubjectDTO("Química", 6.0));
        StudentDTO carla = new StudentDTO(3L, "Carla", null, null, carlaSubjects);

        assertFalse(dao.exists(carla));

        dao.save(carla);

        assertTrue(dao.exists(carla));
    }

    @Test
    @DisplayName("buscar a un estudiante por id")
    void findByIdTest() {
        List<SubjectDTO> juanSubjects = new ArrayList<>();
        juanSubjects.add(new SubjectDTO("Matemática", 9.0));
        juanSubjects.add(new SubjectDTO("Física", 7.0));
        juanSubjects.add(new SubjectDTO("Química", 6.0));
        StudentDTO juan = new StudentDTO(1L, "Juan", null, null, juanSubjects);

        dao.save(juan);

        StudentDTO studentDTO = dao.findById(1L);

        assertEquals(studentDTO, juan);
    }
}
