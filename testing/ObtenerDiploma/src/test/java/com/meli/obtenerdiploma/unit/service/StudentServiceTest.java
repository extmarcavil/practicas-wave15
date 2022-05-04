package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentRepository mockStudentRepository;
    @Mock
    IStudentDAO mockStudentDAO;
    @InjectMocks
    StudentService mockStudentService;

    @Test
    @DisplayName("Crea correctamente un estudiante")
    void createWorking () {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setId(123L);
        newStudent.setStudentName("Pepo");

        Mockito.when(mockStudentDAO.save(newStudent)).

        mockStudentService.create(newStudent);


    }


}
