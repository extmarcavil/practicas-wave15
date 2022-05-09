package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.data.Data;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentDAO studentDao;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;


    /**
     * Creando un estudiante.
     */
    @DisplayName("Creando un estudiante ")
    @Test
    void createStudenttest() {
        //Arrange
        doNothing().when(studentDao).save(Data.STUDENT_DTO_1);
        //doNothing().when(studentDao).save(any(StudentDTO.class));

        //Act
        studentService.create(Data.STUDENT_DTO_1);
        //Assert
        verify(studentDao).save(any(StudentDTO.class));
        verify(studentDao, atLeastOnce()).save(Data.STUDENT_DTO_1);
    }

    /**
     * Buscando un estudiante por Id.
     */
    @Test
    void studnetFindByIdTest() {
        //Arrange
        doReturn(Data.STUDENT_DTO_2).when(studentDao).findById(anyLong());
        /*when(studentDao.findById(anyLong())).thenReturn(s1);*/

        //Act
        StudentDTO stu = studentService.read(10L);

        //Assert
        assertEquals("Jorge", stu.getStudentName());
        assertEquals(2, stu.getSubjects().size());
        verify(studentDao, atLeastOnce()).findById(anyLong());
    }

    /**
     * Actualizando la informacion de un estudiante
     */
    @DisplayName("Actualizando la informacion de un Studiante.")
    @Test
    void studentUpdateTest() {
        //Arrange
        doNothing().when(studentDao).save(any(StudentDTO.class));

        //Act
        studentService.update(Data.STUDENT_DTO_1);

        //Assert
        verify(studentDao, atLeastOnce()).save(any(StudentDTO.class));
    }

    /**
     * Eliminado un estudiante.
     */
    @DisplayName("Eliminando un estudiante.")
    @Test
    void studentDeleteById() {
        //Arrange
        when(studentDao.delete(anyLong())).thenReturn(true);
        //doReturn(true).when(studentDao).delete(1L);

        //Act
        studentService.delete(1L);

        //Assert
        verify(studentDao, atLeastOnce()).delete(1L);
    }

    /**
     * Obtener todos los estudiantes.
     */
    @DisplayName("Obtener todos los estudiantes.")
    @Test
    void getAllStudentTest() {
        //Arrange
        //when(studentRepository.findAll()).thenReturn(Set.of(Data.STUDENT_DTO_3, Data.STUDENT_DTO_4));
        doReturn(Set.of(Data.STUDENT_DTO_3, Data.STUDENT_DTO_4)).when(studentRepository).findAll();

        //Act
        Set<StudentDTO> setStudent = studentService.getAll();

        //Assert
        assertEquals(2, setStudent.size());
        verify(studentRepository, atLeastOnce()).findAll();
    }
}