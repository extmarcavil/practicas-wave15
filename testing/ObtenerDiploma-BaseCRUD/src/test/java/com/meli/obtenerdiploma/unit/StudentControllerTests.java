package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    private StudentDTO studentDTO1, studentDTO2;
    private SubjectDTO subjectDTO1, subjectDTO2, subjectDTO3, subjectDTO4;
    private Set<StudentDTO> students;

    @BeforeEach
    void setUp() {
        subjectDTO1 = new SubjectDTO("Historia", 8d);
        subjectDTO2 = new SubjectDTO("Matemática", 10d);
        studentDTO1 = new StudentDTO(1L, "Test", null, null, List.of(subjectDTO1, subjectDTO2));

        SubjectDTO subjectDTO3 = new SubjectDTO("Lengua", 8d);
        SubjectDTO subjectDTO4 = new SubjectDTO("Geografía", 10d);
        studentDTO2 = new StudentDTO(1L, "Test2", null, null, List.of(subjectDTO3, subjectDTO4));

        students = Set.of(studentDTO1, studentDTO2);
    }

    @Test
    void listAll(){
        //arrange
        when(studentService.getAll()).thenReturn(students);

        //act
        Set<StudentDTO> allStudents = studentController.listStudents();

        //assert
        assertEquals(allStudents.size(), 2);
    }

    @Test
    void createStudentSuccesfully(){
        //arrange
        studentDTO1.setId(null);
        doNothing().when(studentService).create(any(StudentDTO.class));

        //act
        ResponseEntity response = studentController.registerStudent(studentDTO1);

        //assert
        Mockito.verify(studentService, times(1)).create(any(StudentDTO.class));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void findExistentStudentById(){
        //arrange
        when(studentService.read(any(Long.class))).thenReturn(studentDTO1);

        //act
        //StudentDTO resultado = studentController.getStudent(1L);

        //assert
        assertDoesNotThrow(() -> studentController.getStudent(1L));
        verify(studentService, times(1)).read(any(Long.class));
        //Assertions.assertEquals(resultado.getId(), studentDTO1.getId());
    }

    @Test
    void findNonExistentStudentById(){
        //arrange
        when(studentService.read(any(Long.class))).thenThrow(StudentNotFoundException.class);

        //act


        //assert
        assertThrows(StudentNotFoundException.class, () -> studentController.getStudent(1L));
        verify(studentService, times(1)).read(any(Long.class));
    }

    @Test
    void updateStudentSuccessfully(){
        //arrange
        studentDTO1.setStudentName("Test edited");
        doNothing().when(studentService).update(any(StudentDTO.class));

        //act
        ResponseEntity resultado = studentController.modifyStudent(studentDTO1);

        //assert
        verify(studentService, times(1)).update(any(StudentDTO.class));
        assertEquals(resultado.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void deleteExistentStudentById(){
        //arrange
        doNothing().when(studentService).delete(any(Long.class));

        //act
        ResponseEntity resultado = studentController.removeStudent(1L);

        //assert
        verify(studentService, times(1)).delete(any(Long.class));
        assertEquals(resultado.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void deleteNonExistentStudentById(){
        //arrange
        doNothing().when(studentService).delete(any(Long.class));

        //act
        ResponseEntity resultado = studentController.removeStudent(1L);

        //assert
        Mockito.verify(studentService, times(1)).delete(any(Long.class));
        assertEquals(resultado.getStatusCode(), HttpStatus.OK);
    }

}
