package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentRepositoryTest {

    IStudentRepository repo;

    IStudentDAO sdao;

    @BeforeEach
    void setup(){
        sdao = new StudentDAO();
        repo = new StudentRepository();
    }

    //Solo tiene el metodo findAll
    //Caso vacio:
    @Test
    @DisplayName("findAll: paso repo = null")
    void nullStudentFindAll(){
        // arrange
        IStudentRepository repoNull = null;
        // assert&&act
        Assertions.assertThrows(NullPointerException.class, () -> repoNull.findAll());
    }


    @Test
    @DisplayName("findAll: con datos del repo")
    void repoFindAll(){
        // arrange

        // assert&&act
        Assertions.assertEquals(3, repo.findAll().size());
    }



}
