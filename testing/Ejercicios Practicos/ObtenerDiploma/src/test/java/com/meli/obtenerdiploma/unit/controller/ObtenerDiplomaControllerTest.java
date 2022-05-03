package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.unit.utils.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    void getStudentOk(){
        //arrange
        StudentDTO mock= StudentFactory.getJuan();
        Mockito.when(service.read(1L)).thenReturn(mock);
        //act
        StudentDTO result=controller.getStudent(1L);
        //assert
        Assertions.assertAll(
                ()->Assertions.assertNotNull(result),
                ()->Mockito.verify(service,Mockito.times(1)).read(1L)
        );
    }

    @Test
    void createStudentOk(){
        StudentDTO student= StudentFactory.getJuan();
        ResponseEntity<?> response=controller.registerStudent(student);
        Assertions.assertAll(
                ()->Mockito.verify(service,Mockito.times(1)).create(student),
                ()->Assertions.assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->Assertions.assertNull(response.getBody())
        );
    }

    @Test
    void removeStudentOk(){
        ResponseEntity<?> response=controller.removeStudent(1L);
        Assertions.assertAll(
                ()->Mockito.verify(service,Mockito.times(1)).delete(1L),
                ()->Assertions.assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->Assertions.assertNull(response.getBody())
        );
    }

    @Test
    void listStudentOk(){
        Set<StudentDTO> mock=Set.of(
                StudentFactory.getJuan(),
                StudentFactory.getPedro()
        );
        Mockito.when(service.getAll()).thenReturn(mock);
        Set<StudentDTO> response=controller.listStudents();
        Assertions.assertAll(
                ()->Mockito.verify(service,Mockito.times(1)).getAll(),
                ()->Assertions.assertEquals(2,response.size()),
                ()->Assertions.assertNotNull(response)
        );
    }

    @Test
    void modifyStudentOk(){
        StudentDTO student= StudentFactory.getJuan();
        ResponseEntity<?> response=controller.modifyStudent(student);
        Assertions.assertAll(
                ()->Mockito.verify(service,Mockito.times(1)).update(student),
                ()->Mockito.verify(service,Mockito.times(0)).create(student),
                ()->Mockito.verify(service,Mockito.times(0)).delete(student.getId()),
                ()->Assertions.assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->Assertions.assertNull(response.getBody())
        );
    }


}
