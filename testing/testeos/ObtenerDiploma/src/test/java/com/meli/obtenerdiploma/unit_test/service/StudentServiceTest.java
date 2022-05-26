package com.meli.obtenerdiploma.unit_test.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.utils.StudentDTOFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;


    @Test
    void createSuccess(){
        StudentDTO student1= StudentDTOFactory.createStudent();
        studentService.create(student1);

        // MOCK
        Mockito.verify(studentDAO,Mockito.times(1)).save(student1);

    }
    @Test
    void readSuccess(){
        StudentDTO student1= StudentDTOFactory.createStudent();
        studentService.read(student1.getId());

        // MOCK
        Mockito.verify(studentDAO,Mockito.times(1)).findById(student1.getId());

    }
    @Test
    void updateSuccess(){
        StudentDTO student1= StudentDTOFactory.createStudent();
        studentService.update(student1);

        // MOCK
        Mockito.verify(studentDAO,Mockito.times(1)).save(student1);

    }

    @Test
    void deleteSuccess(){
        StudentDTO student1= StudentDTOFactory.createStudent();
        studentService.delete(student1.getId());

        // MOCK
        Mockito.verify(studentDAO,Mockito.times(1)).delete(student1.getId());

    }

    @Test
    void getAllVerify() {
        StudentDTO student1= StudentDTOFactory.createStudent();
        studentService.getAll();
        Mockito.verify(studentRepository,Mockito.times(1))
                .findAll();
    }
}
