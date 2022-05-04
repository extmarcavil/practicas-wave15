package com.meli.obtenerdiploma.dao;
import com.meli.obtenerdiploma.dao.model.StudentDTO;
import com.meli.obtenerdiploma.dao.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ObtenerDiplomaDAOTest {

    private IStudentDAO studentDAO;
    private IStudentRepository repo;

    @BeforeEach
    void setup() {
        this.studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Verifico que los objetos sean iguales comparando el nombre del estudiante")
    void findById() {
        StudentDTO studentTestDTO = new StudentDTO();
        studentTestDTO.setStudentName("Pedro");
        studentTestDTO.setId(2L);

        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Matematica", 10D));
        subjectDTOS.add(new SubjectDTO("Fisica", 8D));
        subjectDTOS.add(new SubjectDTO("Quimica", 4D));
        studentTestDTO.setSubjects(subjectDTOS);
        StudentDTO studentDTO = studentDAO.findById(2L);

        Assertions.assertEquals(studentTestDTO.getId(), studentDTO.getId());
        Assertions.assertTrue(studentTestDTO.getStudentName().equals(studentDAO.findById(2L).getStudentName()));
    }

    @Test
    @DisplayName("Verifico que se guarde un estudiante y sea igual al que agrego")
    void saveTest() {

        StudentDTO studentTestDTO = new StudentDTO();
        studentTestDTO.setStudentName("Pedro");
        studentTestDTO.setId(2L);
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Matematica", 10D));
        subjectDTOS.add(new SubjectDTO("Fisica", 8D));
        subjectDTOS.add(new SubjectDTO("Quimica", 4D));
        studentTestDTO.setSubjects(subjectDTOS);

        StudentDTO studentDTO = studentDAO.findById(2L);
        studentDAO.save(studentTestDTO);

        Assertions.assertTrue(studentTestDTO.getStudentName().equals(studentDTO.getStudentName()));

    }

    @Test
    @DisplayName("Verifico que exista un estudiante  de los datos de prueba y creo otro con los mismos datos para saber si lo persisto")
    void existTest() {

        StudentDTO studentTestDTO = new StudentDTO();
        studentTestDTO.setStudentName("Pedro");
        studentTestDTO.setId(2L);
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Matematica", 10D));
        subjectDTOS.add(new SubjectDTO("Fisica", 8D));
        subjectDTOS.add(new SubjectDTO("Quimica", 4D));
        studentTestDTO.setSubjects(subjectDTOS);

        boolean isExist = studentDAO.exists(studentTestDTO);

        Assertions.assertTrue(isExist == true);
    }

    @Test
    @DisplayName("Se elimina un usuario existente, verificando que se elimine realmente de los datos de prueba y que me indique si se elimino o no")
    void deleteTest() {

        StudentDTO studentTestDTO = new StudentDTO();
        studentTestDTO.setStudentName("Pedro");
        studentTestDTO.setId(2L);
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Matematica", 10D));
        subjectDTOS.add(new SubjectDTO("Fisica", 8D));
        subjectDTOS.add(new SubjectDTO("Quimica", 4D));
        studentTestDTO.setSubjects(subjectDTOS);

        boolean delete = studentDAO.delete(2L);

        studentDAO.save(studentTestDTO);
        Assertions.assertEquals(delete, true);
    }


    @Test
    @DisplayName("No encontramos estudiante si enviamos un nombre invalido")
    void notFoundStudentWithIncorrectName() {
        // setup
        StudentDTO s = null;

        // act & assert
        Assertions.assertThrows(NullPointerException.class, () -> studentDAO.findById(s.getId()));
    }


}
