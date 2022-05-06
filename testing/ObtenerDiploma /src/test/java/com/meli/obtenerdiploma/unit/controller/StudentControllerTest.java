package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.MakeStudentsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    public void registrarStudent(){

        //arrange
        StudentDTO stundt1 = MakeStudentsDTO.StudentDTOId1();

        //act
        controller.registerStudent(stundt1);

        //assert
        verify(service, atLeastOnce()).create(stundt1);
    }


    @Test
    public void getStudent(){

        //arrange
        StudentDTO expected = MakeStudentsDTO.StudentDTOId1();
        Long id = expected.getId();

        //Mock
        Mockito.when(service.read(id)).thenReturn(expected);

        //act
        StudentDTO actual = controller.getStudent(id);

        //assert
        assertEquals(expected,actual);

    }

    @Test
    public void modifyStudent(){

        //arrange
        StudentDTO stundt1 = MakeStudentsDTO.StudentDTOId1();

        //act
        controller.modifyStudent(stundt1);

        //assert
        verify(service, atLeastOnce()).update(stundt1);
    }

    @Test
    public void removeStudent(){

        //arrange
        StudentDTO stundt1 = MakeStudentsDTO.StudentDTOId1();
        Long id = stundt1.getId();

        //act
        controller.removeStudent(id);

        //assert
        verify(service, atLeastOnce()).delete(id);
    }

    @Test
    public void getAll(){

        //arrange
        Set<StudentDTO> expected = MakeStudentsDTO.getStudentSet();

        //Mock
        Mockito.when(service.getAll()).thenReturn(expected);

        //act
        Set<StudentDTO> actual = controller.listStudents();

        //assert
        assertEquals(expected,actual);

    }
}
