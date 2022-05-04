package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.dao.IStudentRepository;
import com.meli.obtenerdiploma.dao.StudentRepository;
import com.meli.obtenerdiploma.dao.model.StudentDTO;
import com.meli.obtenerdiploma.dao.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Iterables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentRepositoryTest {

    private IStudentRepository studentRepository;

    @BeforeEach
    void setup(){
        studentRepository  = new StudentRepository();
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

        boolean isExistOnList = !existOnList(studentList, studentRepository.findAll());
        Assertions.assertEquals(isExistOnList, true);
    }

    private boolean existOnList(Set<StudentDTO> studentList, Set<StudentDTO> all) {
        boolean acum1 = true;
        for (StudentDTO s1: studentList) {
            for (StudentDTO s2: all) {
                        acum1 = acum1 && s1.getStudentName().equals(s2.getStudentName());
            }
        }
        return  acum1;
    }
}
