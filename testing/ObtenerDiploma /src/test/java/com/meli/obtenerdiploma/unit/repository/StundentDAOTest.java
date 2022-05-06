package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.utils.MakeStudentsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StundentDAOTest {

    IStudentDAO studentDAO;

    @BeforeEach
    void setup(){
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Se encuantra el estudiante por el id")
    public void findById(){
        //arrange
        StudentDTO expected = MakeStudentsDTO.StudentDTOId1();

        //act
       StudentDTO actual = studentDAO.findById(1L);

        //assert
        Assertions.assertEquals(expected,actual
                ,"No se encontro el estudiante con ese id");
    }

    @Test
    @DisplayName("No se encuantra el estudiante por el id")
    public void NotfindById(){

        //arrange
        Long expected = 0000L;

        //assert y act
        Assertions.assertThrows(StudentNotFoundException.class,()->studentDAO.findById(expected)
                ,"Se encontro el estudiante");

    }

    @Test
    @DisplayName("Existe el estudiante")
    public void exist(){
        //arrange
        StudentDTO expected = MakeStudentsDTO.StudentDTOId1();

        //act
        //StudentDTO actual = studentDAO.findById(1L);

        //act y assert
        Assertions.assertTrue(studentDAO.exists(expected));
    }

    @Test
    @DisplayName("Estudiante igual a null")
    public void notExist(){
        //arrange
        StudentDTO expected = null;

        //act
        //StudentDTO actual = studentDAO.findById(1L);

        //assert y act
        Assertions.assertThrows(NullPointerException.class,()->studentDAO.exists(expected));
    }

    @Test
    @DisplayName("Estudiante no existente")
    public void notExist2(){
        //arrange
        StudentDTO expected = new StudentDTO();
        expected.setId(000000L);

        //assert
        Assertions.assertFalse(studentDAO.exists(expected));
    }

    @Test
    @DisplayName("Agregar estudiante")
    public void saveStudent(){
        StudentDTO studentDTO = MakeStudentsDTO.StudentDTOId3();
        studentDAO.save(studentDTO);
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("Agregar estudiante null")
    public void saveStudent2(){
        StudentDTO studentDTO = null;
        Assertions.assertThrows(NullPointerException.class,()->studentDAO.save(studentDTO));
    }

    @Test
    @DisplayName("Modificar estudiante")
    public void saveStudent3(){
        StudentDTO studentDTO = MakeStudentsDTO.StudentDTOId3();
        studentDTO.setId(2L);
        studentDAO.save(studentDTO);
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("borrar estudiante")
    public void deleteStudent(){
        Long id = 3L;
        studentDAO.delete(id);
        Assertions.assertThrows(StudentNotFoundException.class,()->studentDAO.findById(id));
    }

    @Test
    @DisplayName("borrar estudiante inexistente")
    public void deleteStudent2(){
        Long id = 3000000L;
        studentDAO.delete(id);
        Assertions.assertThrows(StudentNotFoundException.class,()->studentDAO.findById(id));
    }







}
