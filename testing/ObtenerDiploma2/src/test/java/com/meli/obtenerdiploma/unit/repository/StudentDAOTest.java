package com.meli.obtenerdiploma.unit.repository;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class StudentDAOTest {
    @Mock
    IStudentDAO repository;

    @BeforeEach
    void setup(){
        repository = new StudentDAO();
    }

    @Test
    @DisplayName("No encontramos el estudiante si pasamos un ID null")
    void notFoundFindByID(){
        // arrange
        Long studentId = null;

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class,  () -> repository.findById(studentId));
    }

    @Test
    @DisplayName("Buscar alumno por ID.")
    void findById(){
        Assertions.assertNotNull(repository.findById(1L));
    }

    @Test
    @DisplayName("Eliminar un alumno.")
    void delete(){
        Assertions.assertFalse(repository.delete(10L));
    }
}