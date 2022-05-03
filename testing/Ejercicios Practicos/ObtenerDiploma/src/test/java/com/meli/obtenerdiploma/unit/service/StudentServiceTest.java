package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.unit.utils.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService service;

    @Test
    void createOk(){
        //arrange
        StudentDTO student= StudentFactory.getPedro();

        //act
        service.create(student);

        //assert
        Mockito.verify(studentDAO,Mockito.times(1)).save(student);
    }

    @Test
    void readOk(){
        //arrange
        StudentDTO mock= StudentFactory.getJuan();
        Mockito.when(studentDAO.findById(1L)).thenReturn(mock);

        //act
        service.read(1L);
        Assertions.assertAll(
                ()->Assertions.assertEquals("Juan",mock.getStudentName()),
                ()->Mockito.verify(studentDAO,Mockito.times(1)).findById(1L)
        );
    }

    @Test
    void updateOk(){
        //arrange
        StudentDTO mock= StudentFactory.getJuan();

        //act
        service.update(mock);

        //assert
        Assertions.assertAll(
                ()->Mockito.verify(studentDAO,Mockito.times(1)).save(mock)
        );
    }

    //Cambiar implementacion.. si se recibe null en el servicio se deberia ejecutar una excepcion
    @Test
    void updateNotOk(){

        StudentDTO update=new StudentDTO();
        update.setId(1L);
        Mockito.when(studentDAO.findById(1L)).thenReturn(null);

        //act & assert
        Assertions.assertThrows(RuntimeException.class,()->service.update(update));
    }

    @Test
    void deleteOk(){
        StudentDTO mock= StudentFactory.getJuan();
        Mockito.when(studentDAO.findById(1L)).thenReturn(mock);
        //act
        service.delete(1L);
        Assertions.assertAll(
                ()->Mockito.verify(studentDAO,Mockito.times(1)).delete(1L)
        );
    }

    //Agregar excepcion
    @Test
    void deleteNotOk(){
        //act
        service.delete(null);
        Assertions.assertAll(
                ()->Mockito.verify(studentDAO,Mockito.times(0)).delete(null)
        );
    }


    @Test
    void findAll(){
        //arrange
        Set<StudentDTO> mockList=Set.of(
                StudentFactory.getJuan(),
                StudentFactory.getPedro()
        );
        Mockito.when(studentRepository.findAll()).thenReturn(mockList);
        //act
        Set<StudentDTO> result = service.getAll();
        //assert
        Assertions.assertAll(
                ()->Assertions.assertNotNull(result),
                ()->Assertions.assertEquals(2,result.size()),
                ()->Mockito.verify(studentRepository,Mockito.times(1)).findAll()
        );

    }

}
