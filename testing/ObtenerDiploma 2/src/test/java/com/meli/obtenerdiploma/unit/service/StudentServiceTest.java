package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    SubjectDTO subject1, subject2, subject3, subject4;
    StudentDTO student1, student2;
    Set<StudentDTO> students;

    @BeforeEach
    void setup(){
        subject1 = new SubjectDTO("Matemática", 10.0);
        subject2 = new SubjectDTO("Física", 8.0);
        student1 = new StudentDTO(1L, "Jose", null, null, List.of(subject1, subject2));
        subject3 = new SubjectDTO("Quimíca", 10.0);
        subject4 = new SubjectDTO("Lengua", 8.0);
        student2 = new StudentDTO(2L, "Pedro", null, null, List.of(subject3, subject4));

        students = Set.of(student1, student2);
    }

    @Test
    @DisplayName("Crear un estudiante correcto")
    void createStudentSuccesfully(){
        //arrange
        student1.setId(1L);
        Mockito.doNothing().when(studentDAO).save(student1);

        //act
        studentService.create(student1);

        //assert
        Mockito.verify(studentDAO).save(student1);
        Mockito.verify(studentDAO, Mockito.times(1)).save(student1);
    }

    @Test
    @DisplayName("Busqueda por ID correcto")
    void findReadExistentStudentById(){
        //arrange
        Mockito.when(studentDAO.findById(1L)).thenReturn(student1);

        //act & assert
        Assertions.assertNotNull(studentService.read(1L));

        Mockito.verify(studentDAO).findById(1L);
        Mockito.verify(studentDAO, Mockito.times(1)).findById(1L);
    }

    @Test
    @DisplayName("Busqueda por ID incorrecto")
    void findReadNotExistentStudentById(){
        //arrange
        Mockito.when(studentDAO.findById(3L)).thenThrow(StudentNotFoundException.class);

        //act & assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.read(3L));

        Mockito.verify(studentDAO).findById(3L);
        Mockito.verify(studentDAO, Mockito.times(1)).findById(3L);
    }

    @Test
    @DisplayName("Modificacion de estudiante correcto")
    void updateStudentSuccessfully(){
        //arrange
        student1.setStudentName("Miguel");
        Mockito.doNothing().when(studentDAO).save(student1);

        //act
        studentService.update(student1);

        //assert
        Mockito.verify(studentDAO, Mockito.times(1)).save(student1);
    }

    @Test
    @DisplayName("Eliminar estudiante con ID correcto")
    void deleteStudentById(){
        //arrange
        Mockito.when(studentDAO.delete(1L)).thenReturn(true);

        //act
        studentService.delete(1L);

        //assert
        Mockito.verify(studentDAO, Mockito.times(1)).delete(1L);
    }

    @Test
    @DisplayName("Eliminar estudiante con ID incorrecto")
    void notDeleteStudentById(){
        //arrange
        Mockito.when(studentDAO.delete(3L)).thenReturn(false);

        //act
        studentService.delete(3L);

        //assert
        Mockito.verify(studentDAO, Mockito.times(1)).delete(3L);
    }


    @Test
    @DisplayName("Listar todos los estudiantes")
    void findAll(){
        //arrange
        Mockito.when(studentRepository.findAll()).thenReturn(students);

        //act
        Set<StudentDTO> allStudents = studentService.getAll();

        //assert
        Mockito.verify(studentRepository, Mockito.times(1)).findAll();
        Assertions.assertEquals(allStudents.size(), 2);
    }

}
