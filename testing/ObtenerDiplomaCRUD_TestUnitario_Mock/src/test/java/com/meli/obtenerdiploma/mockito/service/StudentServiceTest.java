package com.meli.obtenerdiploma.mockito.service;

import com.meli.obtenerdiploma.dao.IStudentDAO;
import com.meli.obtenerdiploma.dao.IStudentRepository;
import com.meli.obtenerdiploma.dao.model.StudentDTO;
import com.meli.obtenerdiploma.dao.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Verificar que puedo guardar un estudiante")
    void createTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(5l);
        studentDTO.setStudentName("Martin");
        List<SubjectDTO> subjectDTOS1 = new ArrayList<>();
        subjectDTOS1.add(new SubjectDTO("Matematica", 8D));
        subjectDTOS1.add(new SubjectDTO("Fisica", 8D));
        subjectDTOS1.add(new SubjectDTO("Quimica", 8D));
        studentDTO.setSubjects(subjectDTOS1);

        studentDAO.save(studentDTO);

        Mockito.when(studentDAO.findById(5L)).thenReturn(studentDTO);


        Assertions.assertEquals(studentDTO.getStudentName(), studentDAO.findById(5L).getStudentName());
    }
    @Test
    @DisplayName("Verificar que exista el usuario")
    void readTest(){
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
    @DisplayName("Verificar que pueda actualizar un estudiante")
    void updateTest(){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(5l);
            studentDTO.setStudentName("Martin");
            List<SubjectDTO> subjectDTOS1 = new ArrayList<>();
            subjectDTOS1.add(new SubjectDTO("Matematica", 8D));
            subjectDTOS1.add(new SubjectDTO("Fisica", 8D));
            subjectDTOS1.add(new SubjectDTO("Quimica", 8D));
            studentDTO.setSubjects(subjectDTOS1);

            studentDAO.save(studentDTO);

            Mockito.when(studentDAO.findById(5L)).thenReturn(studentDTO);

            studentDTO.setStudentName("Agustin");

            studentDAO.save(studentDTO);


            Assertions.assertEquals(studentDTO.getStudentName(), studentDAO.findById(5L).getStudentName());
    }
    @Test
    @DisplayName("Verificar que pueda eliminar un estudiante")
    void deleteTest(){


            StudentDTO studentTestDTO = new StudentDTO();
            studentTestDTO.setStudentName("Facundon");
            studentTestDTO.setId(6L);
            List<SubjectDTO> subjectDTOS = new ArrayList<>();
            subjectDTOS.add(new SubjectDTO("Matematica", 8D));
            subjectDTOS.add(new SubjectDTO("Fisica", 8D));
            subjectDTOS.add(new SubjectDTO("Quimica", 8D));
            studentTestDTO.setSubjects(subjectDTOS);

            boolean delete = studentDAO.delete(6L);


            Mockito.when(studentDAO.delete(6L)).thenReturn(true);

            studentDAO.save(studentTestDTO);

            Assertions.assertTrue(studentDAO.delete(6L) ==  true);
  }


    @Test
    @DisplayName("Obtengo la lista de todos los estudiantes")
    void listAllStudiants(){

        Set<StudentDTO> studentList = new HashSet<>();
        List<SubjectDTO> subjectDTOS1 = new ArrayList<>();
        subjectDTOS1.add(new SubjectDTO("Matematica", 9D));
        subjectDTOS1.add(new SubjectDTO("Fisica", 7D));
        subjectDTOS1.add(new SubjectDTO("Quimica", 6D));

        List<SubjectDTO> subjectDTOS2 = new ArrayList<>();
        subjectDTOS2.add(new SubjectDTO("Matematica", 10D));
        subjectDTOS2.add(new SubjectDTO("Fisica", 8D));
        subjectDTOS2.add(new SubjectDTO("Quimica", 4D));
        StudentDTO stu1 = new StudentDTO(1L, "Juan", "", null, subjectDTOS1);
        StudentDTO stu2 = new StudentDTO(2L, "Pedro", "", null, subjectDTOS2);
        studentList.add(stu1);
        studentList.add(stu2);

        Mockito.when(studentRepository.findAll()).thenReturn(studentList);

        Assertions.assertTrue(studentRepository.findAll() == studentList);
    }

}
