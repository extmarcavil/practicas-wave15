package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void create() {
        StudentDTO student = new StudentDTO();
        Mockito.doNothing().when(studentDAO).save(student);
        studentDAO.save(student);
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(student);
    }

    @Test
    void delete(){
        Mockito.when(studentDAO.delete(5L)).thenReturn(true);
        studentDAO.delete(5L);
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).delete(5L);
    }

    @Test
    void read(){
        StudentDTO student = new StudentDTO();
        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenReturn(student);
        StudentDTO result = studentService.read(Mockito.anyLong());
        Assertions.assertNotNull(result);
    }

    @Test
    void readFail(){
        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenThrow(StudentNotFoundException.class);
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.read(Mockito.anyLong()));
    }

    @Test
    public void getAll(){
        Set<StudentDTO> students = new HashSet<>();
        StudentDTO s = new StudentDTO(null, "Alberto", "intermedio", 6.0, new ArrayList<>());
        students.add(s);
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> list = studentService.getAll();
        Assertions.assertNotNull(list.contains(s));
    }

}
