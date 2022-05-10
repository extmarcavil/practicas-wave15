package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentDAOTest {

    IStudentDAO studentDAO;

    @BeforeEach
    void setup(){
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Buscamos un estudiante")
    void existCorrectStudent(){
        //arrange
        StudentDTO newStudentDTO = new StudentDTO();
        List<SubjectDTO> listSubj = new ArrayList<SubjectDTO>();
        SubjectDTO sub = new SubjectDTO();

        newStudentDTO.setId(1L);
        newStudentDTO.setStudentName("Juan");
        newStudentDTO.setAverageScore(null);
        newStudentDTO.setMessage(null);

        sub.setName("Matematica");
        sub.setScore(9.0);
        listSubj.add(sub);

        sub.setName("Fisica");
        sub.setScore(7.0);
        listSubj.add(sub);

        sub.setName("Quimica");
        sub.setScore(6.0);
        listSubj.add(sub);

        newStudentDTO.setSubjects(listSubj);

        // act & assert
        Assertions.assertEquals(true, studentDAO.exists(newStudentDTO));
    }

    @Test
    @DisplayName("No encontramos el estudiante si pasamos un ID null")
    void notFoundFindByID() {
        // arrange
        Long id = null;

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    @DisplayName("Borramos un estudiante por medio de su ID")
    void deleteCorrectStudent(){
        // arrange
        Long id = 2L;

        //act & assert
        Assertions.assertEquals(true, studentDAO.delete(id));
    }

    @Test
    @DisplayName("Intentamos borrar un estudiante por medio de su ID que no existe")
    void deleteIncorrectStudent(){
        //arrange
        Long id = 10L;

        Assertions.assertNotEquals(true, studentDAO.delete(id));
    }

}
