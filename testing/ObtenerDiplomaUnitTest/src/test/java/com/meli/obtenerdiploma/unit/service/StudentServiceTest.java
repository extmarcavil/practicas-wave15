package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO mockStudentDAO;

    @Mock
    StudentRepository mockStudentRepository;

    @InjectMocks
    StudentService studentService;


    @Test
    @DisplayName("Comprobar la creacieon de un estudiante")
    void createNewStudentOk(){
        // arrange
        StudentDTO studentDTO = StudentFactory.createStudentOne();
        // act & mock
        doNothing().when(mockStudentDAO).save(studentDTO);
        studentService.create(studentDTO);
        // assert
       verify(mockStudentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("buscar un estudiante por Id valido")
    void readStudentByIdOk(){
        // arrange
        Long id = 2L;
        StudentDTO expected = StudentFactory.getStudentPedroInJson();
        // act & mock
        when(mockStudentDAO.findById(id)).thenReturn(expected);
        StudentDTO result = studentService.read(id);
        // assert
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("Actualizar datos de un estudiante")
    void updateStudentOk(){
        // arrange
        StudentDTO studentDTO = StudentFactory.getStudentPedroInJson();
        studentDTO.getSubjects().get(0).setScore(7.0);
        // act & mock
        doNothing().when(mockStudentDAO).save(studentDTO);
        studentService.update(studentDTO);
        // assert
        verify(mockStudentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("Eliminar un estudiante")
    void deleteStudentOk(){
        // arrange
        Long id = 1L;
        // act & mock
        when(mockStudentDAO.delete(id)).thenReturn(true);
        studentService.delete(id);
        // assert
        verify(mockStudentDAO, times(1)).delete(id);
    }

    @Test
    @DisplayName("listar todos los alumnos")
    void getAllStudentValid(){
        // arrange
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(StudentFactory.getStudentJuanInJson());
        expected.add(StudentFactory.getStudentPedroInJson());

        // act
        when(mockStudentRepository.findAll()).thenReturn(expected);
        // assert
        Set<StudentDTO> result = studentService.getAll();
        assertAll(
                () -> assertEquals(2, result.size()),
                () -> assertEquals(expected, result)

        );
    }

}
