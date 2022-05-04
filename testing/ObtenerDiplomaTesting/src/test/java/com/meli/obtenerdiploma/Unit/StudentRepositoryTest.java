package com.meli.obtenerdiploma.Unit;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentRepositoryTest {
    IStudentRepository repository;
    IStudentDAO studentDao;

    @BeforeEach
    void setup(){
        studentDao = new StudentDAO();
        repository = new StudentRepository();
    }

    @Test
    @DisplayName("FindAll con datos Null")
    void nullFindAll(){

        //Arrage
        IStudentRepository repo = null;
        //Act
        Assertions.assertThrows(NullPointerException.class, () -> repo.findAll());

        //Assert

    }

    @Test
    @DisplayName("FindAll con datos ingresados")
    void notNullAll(){
        //Arrage

        //Act
        Assertions.assertEquals(2, repository.findAll().size());
        //Assert
    }
}
