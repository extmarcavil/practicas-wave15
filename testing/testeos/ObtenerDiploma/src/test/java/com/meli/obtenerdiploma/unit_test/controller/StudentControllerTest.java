package com.meli.obtenerdiploma.unit_test.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.StudentDTOFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudent() {
        StudentDTO student1= StudentDTOFactory.createStudent();
        ResponseEntity<?> result=studentController.registerStudent(student1);

        // MOCK
        Mockito.verify(studentService,Mockito.times(1))
                .create(student1);

        Assertions.assertEquals(ResponseEntity.ok(null),result);

    }
    @Test
    void registerStudentFail() {
        StudentDTO student1= StudentDTOFactory.createStudent();
        student1.setStudentName("asd");
        ResponseEntity<?> result=studentController.registerStudent(student1);

        // MOCK
        /*Mockito.verify(studentService,Mockito.times(1))
                .create(null);*/

        System.out.println(result);

    }

    @Test
    void getStudent() {

        StudentDTO student1= StudentDTOFactory.createStudent();
        studentController.getStudent(student1.getId());

        // MOCK
        Mockito.verify(studentService,Mockito.times(1))
                .read(student1.getId());
    }

    @Test
    void modifyStudent() {

        StudentDTO student1= StudentDTOFactory.createStudent();
        studentController.modifyStudent(student1);

        // MOCK
        Mockito.verify(studentService,Mockito.times(1))
                .update(student1);
    }

    @Test
    void removeStudent() {
        StudentDTO student1= StudentDTOFactory.createStudent();
        studentController.removeStudent(student1.getId());

        // MOCK
        Mockito.verify(studentService,Mockito.times(1))
                .delete(student1.getId());
    }

    @Test
    void listStudents() {
        StudentDTO student1= StudentDTOFactory.createStudent();
        studentController.listStudents();

        // MOCK
        Mockito.verify(studentService,Mockito.times(1))
                .getAll();
    }
}