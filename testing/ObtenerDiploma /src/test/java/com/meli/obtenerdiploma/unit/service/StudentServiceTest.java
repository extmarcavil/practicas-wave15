package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.utils.MakeStudentsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO repository;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService service;

    @Test
    public void createStudent(){

        //arrange
        StudentDTO student1 = MakeStudentsDTO.StudentDTOId1();

        //Mock
        Mockito.doNothing().when(repository).save(student1);

        //act
        service.create(student1);

        //assert
        Mockito.verify(repository,Mockito.atLeast(1)).save(student1);
    }

    @Test
    public void read(){
        //arrange
        StudentDTO expected = MakeStudentsDTO.StudentDTOId1();

        //Mock
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(expected);

        //act
        StudentDTO actual = repository.findById(1L);

        //assert
        Assertions.assertEquals(expected,actual,
                "Los estudiantes no son iguales");
    }

    @Test
    public void updateStudent(){

        //arrange
        StudentDTO student1 = MakeStudentsDTO.StudentDTOId1();

        //Mock
        Mockito.doNothing().when(repository).save(student1);

        //act
        service.update(student1);

        //assert
        Mockito.verify(repository,Mockito.atLeast(1)).save(student1);
    }

    @Test
    public void deleteStudent(){

        //arrange
        Long id = 3L;

        //Mock
        //Mockito.doNothing().when(repository).delete(Mockito.anyLong());
        Mockito.when(repository.delete(Mockito.anyLong())).thenReturn(true);

        //act
        service.delete(id);

        //assert
        Assertions.assertAll(
                ()-> Mockito.verify(repository,Mockito.atLeast(1)).delete(id)
        );
    }

    @Test
    public void getAll(){
        //arrange
        Set<StudentDTO> expected = MakeStudentsDTO.getStudentSet();

        //Mock
        Mockito.when(studentRepository.findAll()).thenReturn(expected);

        //act
        Set<StudentDTO> actual = studentRepository.findAll();

        //assert
        Assertions.assertEquals(expected,actual,
                "Los estudiantes no son iguales");
    }


}
