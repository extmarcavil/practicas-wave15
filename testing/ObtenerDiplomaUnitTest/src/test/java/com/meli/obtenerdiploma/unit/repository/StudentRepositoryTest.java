package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


/*
Se asume que:
    - No se puede modificar un alumno ya que el metodo save, si existe el id, lo borra y guarda el alumno con otro Id
 */
public class StudentRepositoryTest {

    IStudentRepository repository;
    IStudentDAO studentDAO;

    @BeforeEach
    void setup(){
        repository = new StudentRepository();
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("agregar un nuevo alumno con datos correctos")
    void addNewStudentOk(){
        // arrange
        StudentDTO studentDTO = StudentFactory.createStudentOne();
        // act
        studentDAO.save(studentDTO);
        // assert
        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("agregar un nuevo alumno null")
    void addNewStudentNotOk(){
        // arrange & act & assert
        assertThrows(NullPointerException.class, () -> studentDAO.save(null));
    }

    @Test
    @DisplayName("buscar un estudiante por Id valido")
    void findStudentByIdOk(){
        // arrange
        Long id = 2L;
        StudentDTO expected = StudentFactory.getStudentPedroInJson();
        // act
        StudentDTO result = studentDAO.findById(id);
        // assert
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("buscar un estudiante por Id null")
    void findStudentByIdInvalid(){
        // arrange & act & assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(null));
    }

    @Test
    @DisplayName("eliminar un alumno con Id correctos")
    void deleteStudentOk(){
        // arrange
        Long id = 2L;
        // act
        boolean result = studentDAO.delete(id);
        // assert
        assertTrue(result);
    }

    @Test
    @DisplayName("eliminar un alumno con Id inexistente")
    void deleteStudentNotOk(){
        // arrange
        Long id = 20L;
        // act & assert
        assertFalse(studentDAO.delete(id));
    }

    @Test
    @DisplayName("listar todos los alumnos")
    void getAllStudentValid(){
        // arrange
        Set<StudentDTO> result = new HashSet<>();
        // act
        result = repository.findAll();
        // assert
        assertEquals(2,result.size());
    }
}
