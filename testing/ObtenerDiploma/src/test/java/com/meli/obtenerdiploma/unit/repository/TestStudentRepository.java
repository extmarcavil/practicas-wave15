package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestStudentRepository {

    private IStudentRepository studentRepository;

    @BeforeEach
    public void initialize() {
        this.studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Ver que el repo devuelva todos los elementos")
    public void test_seeThatFindAllRetrievesAllSutdents() {
        // Given + When
        Integer size = studentRepository.findAll().size();
        // Then
        Assertions.assertTrue(size > 3);
    }
}
