package com.meli.obtenerdiploma.Unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {
    IStudentDAO studentDAO;

    @BeforeEach
    void setup(){

        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Save Esudiante Caso Nulo")
    void saveNullStudent(){
        // arrange
        // assert
        Assertions.assertThrows(NullPointerException.class, ()-> studentDAO.save(null));
        // act
    }

    @Test
    @DisplayName("Save Estuadiante que no existe. Sad way")
    void saveStudent(){
        // arrange
        StudentDTO studentDTO = new StudentDTO(3L,"Nombre","Message",7.0,null);
        // act
        studentDAO.save(studentDTO);
        // assert
        Assertions.assertEquals(studentDTO,studentDAO.findById(3L));
        studentDAO.delete(3L);
    }

    @Test
    @DisplayName("Save Estudiante que exite, good way")
    void saveStudentDuplicated(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L,"Marcelo","Vas como avion",10.0,null);
        //Act
        studentDAO.save(studentDTO);
        //Assert
        Assertions.assertEquals(studentDTO,studentDAO.findById(1L));
    }

    @Test
    @DisplayName("Delete Alumno Existente")
    void deleteStudent(){
        //Arrage
        //Assert
    }


}
