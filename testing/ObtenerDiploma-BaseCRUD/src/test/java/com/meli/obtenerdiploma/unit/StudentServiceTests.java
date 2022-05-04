package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

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
    void findAll(){
        //arrange
        when(studentRepository.findAll()).thenReturn(students);

        //act
        Set<StudentDTO> allStudents = studentService.getAll();

        //assert
        assertEquals(allStudents.size(), 2);
    }

    @Test
    void createStudentSuccesfully(){
        //arrange
        studentDTO1.setId(null);
        doNothing().when(studentDAO).save(any(StudentDTO.class));

        //act
        studentService.create(studentDTO1);

        //assert
        verify(studentDAO, Mockito.times(1)).save(any(StudentDTO.class));
    }

    @Test
    void findExistentStudentById(){
        //arrange
        when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO1);

        //act


        //assert
        assertDoesNotThrow(() -> studentService.read(1L));
        verify(studentDAO, times(1)).findById(any(Long.class));
    }
    @Test
    void findNonExistentStudentById(){
        //arrange
        when(studentDAO.findById(any(Long.class))).thenThrow(StudentNotFoundException.class);

        //act


        //assert
        assertThrows(StudentNotFoundException.class, () -> studentService.read(1L));
        verify(studentDAO, times(1)).findById(any(Long.class));
    }


    @Test
    void updateStudentSuccessfully(){
        //arrange
        studentDTO1.setStudentName("Test edited");
        doNothing().when(studentDAO).save(any(StudentDTO.class));

        //act
        studentService.update(studentDTO1);

        //assert
        verify(studentDAO, times(1)).save(any(StudentDTO.class));
    }

    @Test
    void deleteExistentStudentById(){
        //arrange
        when(studentDAO.delete(any(Long.class))).thenReturn(true);

        //act
        studentService.delete(1L);

        //assert
        verify(studentDAO, times(1)).delete(any(Long.class));
    }

    @Test
    void deleteNonExistentStudentById(){
        //arrange
        when(studentDAO.delete(any(Long.class))).thenReturn(false);

        //act
        studentService.delete(1L);

        //assert
        verify(studentDAO, times(1)).delete(any(Long.class));
    }
}
