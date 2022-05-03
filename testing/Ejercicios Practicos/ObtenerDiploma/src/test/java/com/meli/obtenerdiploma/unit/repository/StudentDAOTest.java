package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.Valid;
import java.util.List;

public class StudentDAOTest {

    StudentDAO dao= new StudentDAO();

    @Test
    void agregarAlumnoOK(){
        //Arrenge
        StudentDTO student= new StudentDTO();
        //--------Seteo de Datos---------/
        student.setId(3L);
        student.setStudentName("Lucas");
        student.setSubjects(List.of(
                new SubjectDTO("Mate",5.),
                new SubjectDTO("Fisica",10.)
        ));
        //Act
        dao.save(student);
        StudentDTO result=dao.findById(3L);
        //assert
        Assertions.assertEquals(student,result);
    }


    @Test
    void agregarAlumnoNull(){
        //Arrenge
        StudentDTO student= null;

        //act and assert
        Assertions.assertThrows(NullPointerException.class,()->dao.save(student));
    }

    @Test
    void findByIdOk(){
        //Arrenge
        StudentDTO expect = new StudentDTO();
        //--------Seteo de Datos---------/
        expect.setId(1L);
        expect.setStudentName("Juan");
        expect.setSubjects(List.of(
                new SubjectDTO("Matemática",9.),
                new SubjectDTO("Física",7.),
                new SubjectDTO("Química",6.)
        ));
        //Act
        StudentDTO result=dao.findById(1L);

        //Assert, Override a Equals and HashCode
        Assertions.assertEquals(expect,result);
    }

    @Test
    void findByIdNotFound(){
        //Arrenge
        Long id=9L;
        //Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class,()-> dao.findById(id));
    }

    @Test
    void findByIdFound(){
        //Arrenge
        Long id=2L;
        //Act & Assert
        Assertions.assertDoesNotThrow(()-> dao.findById(id));
    }

    @Test
    void updateStudentOk(){
        //Arrenge
        StudentDTO expect = new StudentDTO();
        expect.setId(3L);
        expect.setStudentName("Lucas");
        expect.setSubjects(List.of(
                new SubjectDTO("Mate",5.),
                new SubjectDTO("Fisica",10.)
        ));

        String name="Jose";
        expect.setStudentName(name);
        //act
        dao.save(expect);
        //assert
        Assertions.assertEquals(name,dao.findById(3L).getStudentName());

    }


    //El metodo no retorna alguna exception. Cambiar implementacion. Se deberia separar
    //save en create y update.
    @Test
    void updateNotFound(){

        StudentDTO expect = new StudentDTO();
        expect.setId(5L);
        expect.setStudentName("bruno");
        expect.setSubjects(List.of(
                new SubjectDTO("Mate",5.),
                new SubjectDTO("Fisica",10.)
        ));
        //act and assert
        Assertions.assertThrows(RuntimeException.class,()-> dao.save(expect));
    }

    @Test
    void deleteStudentOk(){
        //arr
        Long id=3L;
        //act and assert
        Assertions.assertTrue(dao.delete(id));
    }

    @Test
    void deleteStudentNotFound(){
        //arr
        Long id=4L;
        //act and assert
        Assertions.assertFalse(dao.delete(id));
    }

    //deberia lanzar una exepcion
    @Test
    void deleteStudentNull(){
        //arr
        Long id=null;
        //act and assert
        Assertions.assertThrows(RuntimeException.class,()->dao.delete(id));
    }

}
