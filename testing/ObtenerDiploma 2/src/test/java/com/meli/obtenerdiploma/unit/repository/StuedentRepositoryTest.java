package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StuedentRepositoryTest {

    IStudentRepository repository;

    @BeforeEach
    void setup(){
        repository = new StudentRepository();
    }

    @Test
    @DisplayName("Encontramos todos los estudiantes")
    public void findAll(){
        Set<StudentDTO> studens = repository.findAll();
        Assertions.assertNotNull(studens);
    }



}
