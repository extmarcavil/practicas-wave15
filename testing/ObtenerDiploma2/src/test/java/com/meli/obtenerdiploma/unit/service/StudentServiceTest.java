package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
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
    @DisplayName("Read correcto.")
    public void read(){
        SubjectDTO subjectDTO1 = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 9.0);

        StudentDTO studentDTO = new StudentDTO(1L, "Jose", null, null, List.of(subjectDTO1, subjectDTO2));

        Mockito.when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO resp = studentService.read(1L);

        Assertions.assertNotNull(resp);
    }

    @Test
    @DisplayName("Get All correcto")
    public void getAll(){
        Set<StudentDTO> mockList = new HashSet<>();

        Mockito.when(studentRepository.findAll()).thenReturn(mockList);

        Set<StudentDTO> resp = studentService.getAll();

        Assertions.assertNotNull(resp);
    }
}
