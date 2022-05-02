package com.meli.obtenerdiploma;

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

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOtest {


    IStudentDAO sdao;

    @BeforeEach
    void setup(){
        sdao = new StudentDAO();
    }

    //Divido los tests segun las funcionalidades
    //y para cada una pruebo:
    //Vacio
    //Casos validos
    //Caso invalido (en caso de aplicar)

    //Los datos son traidos del user.json generado en resources.
    //Funcionalidad: StudentDAO::save
    @Test
    @DisplayName("Save: estudiante nulo StudentDAO")
    void nullStudentSave(){
        // arrange
        // assert&&act
        Assertions.assertThrows(NullPointerException.class, () -> sdao.save(null));
    }

    @Test
    @DisplayName("Save: genero estudiante que no exista(caso valido)")
    void studentSave(){
        // arrange
        StudentDTO stu = new StudentDTO(4L,"Nombre","Message", 7.0,null);
        // act
        sdao.save(stu);
        //assert
        Assertions.assertEquals(stu,sdao.findById(4L));
        //Assertions.assertThrows(NullPointerException.class, () -> sdao.save(stu));
        sdao.delete(4L);
    }

    @Test
    @DisplayName("Save: genero estudiante que ya exista(caso valido, debe sobreescribir dato que trajo)")
    void studentSaveDuplicated(){
        // arrange
        StudentDTO stu = new StudentDTO(1L,"Nombre","Message", 7.0,null);
        // act
        sdao.save(stu);
        //assert
        Assertions.assertEquals(stu,sdao.findById(1L));

    }



    ////Funcionalidad: StudentDAO::delete

    @Test
    @DisplayName("Delete: elimino Inexistente")
    void studentDelete(){
        // arrange
        //assert
        Assertions.assertEquals(false, sdao.delete(4L));

    }


    @Test
    @DisplayName("Delete: elimino correctamente")
    void studentDeleteCorrectly(){
        // arrange
        StudentDTO stu = new StudentDTO(4L,"Nombre","Message", 7.0,null);
        // act
        sdao.save(stu);
        //assert
        Assertions.assertEquals(true, sdao.delete(4L));

    }


    //Funcionalidad: StudentDAO::exists
    @Test
    @DisplayName("Exists: estudiante nulo StudentDAO")
    void nullStudentExists(){
        // arrange
        // assert&&act
        Assertions.assertThrows(NullPointerException.class, () -> sdao.exists(null));
    }


    @Test
    @DisplayName("Exists: Verifico si existe un StudentDAO")
    void existsStudentWithCorrectData(){
        // arrange
        //Creo el estudiante para comparar
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática",9.0));
        subjects.add(new SubjectDTO("Física",7.0));
        subjects.add(new SubjectDTO("Química",6.0));
        StudentDTO stu = new StudentDTO(2L,"Pepe","Juan",7.0,subjects);

        // assert&&act
        Assertions.assertTrue(sdao.exists(stu));
    }

    @Test
    @DisplayName("Exists: Verifico que no existe un StudentDAO")
    void existsStudentWithIncorrectData(){
        // arrange
        //Creo el estudiante para comparar
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática",9.0));
        subjects.add(new SubjectDTO("Física",7.0));
        subjects.add(new SubjectDTO("Química",6.0));
        StudentDTO stu = new StudentDTO(4L,"Pepe","Juan",7.0,subjects);

        // assert&&act
        Assertions.assertFalse(sdao.exists(stu));
    }


    //Funcionalidad: StudentDAO::findById
    @Test
    @DisplayName("FindByID: estudiante no existente StudentDAO")
    void notExistsStudentFindByID(){
        // arrange
        // assert&&act
        Assertions.assertThrows(StudentNotFoundException.class, () -> sdao.findById(10L));
    }


    @Test
    @DisplayName("Consulto por estudiante existente en JSON test")
    void findByIdStudExistente(){
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática",9.0));
        subjects.add(new SubjectDTO("Física",7.0));
        subjects.add(new SubjectDTO("Química",6.0));
        StudentDTO stu = new StudentDTO(1L,"Juan",null,null,subjects);

        // act
        StudentDTO stu2compare = sdao.findById(1L);
        //assert
        Assertions.assertEquals(stu,stu2compare);

    }

    @Test
    @DisplayName("Consulto por estudiante existente en JSON test pero comparo con datos incorrectos")
    void findByIdStudInexistente(){
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática",9.0));
        subjects.add(new SubjectDTO("Física",7.0));
        subjects.add(new SubjectDTO("Química",6.0));
        StudentDTO stu = new StudentDTO(1L,"Juan",null,8.0,subjects);

        // act
        StudentDTO stu2compare = sdao.findById(1L);
        //assert
        Assertions.assertNotEquals(stu,stu2compare);

    }

/*
    //Caso combinado que encuentra error: Al eliminar un estudiante,
    //quedan huecos en la secuencia y al agregar estoy sobreescribiendo un dato valido!!!

    @Test
    @DisplayName("Elimino ")
    void studentSaveAndDelete(){
        // arrange
        sdao.delete(1L);
        StudentDTO stu = new StudentDTO(1L,"Nombre","Message", 7.0,null);
        // act
        sdao.save(stu);
        //assert
        Assertions.assertEquals(stu,sdao.findById(1L));
        //Assertions.assertThrows(NullPointerException.class, () -> sdao.save(stu));
        sdao.delete(4L);
    }
*/
}
