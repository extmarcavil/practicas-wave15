package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObetenerDiplomaApplicationTests {

	IStudentDAO repository;

	@BeforeEach
	void setup(){
		repository = new StudentDAO();
	}

	@Test
	@DisplayName(" Buscar alumno por ID")
	public void findStudentById() {
		Long idStudent = 1L;
		Assertions.assertTrue(repository.exists(repository.findById(idStudent)));
	}
}