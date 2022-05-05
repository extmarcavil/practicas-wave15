package com.meli.obtenerdiploma.unit.repository;


import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentRepositoryTest {

    IStudentRepository repository=new StudentRepository();

    @Test
    void countStudent(){
        //act & assert
        Assertions.assertEquals(2,repository.findAll().size());
    }

    @Test
    void listNotNull(){
        //act & assert
        Assertions.assertNotNull(repository.findAll());
    }


}
