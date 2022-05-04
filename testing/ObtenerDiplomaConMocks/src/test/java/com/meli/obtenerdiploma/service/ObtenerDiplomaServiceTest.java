package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class ObtenerDiplomaServiceTest {

    private StudentDTO student;

    @Mock
    private StudentDAO repository;

    @InjectMocks
    private ObtenerDiplomaService service;

    @BeforeEach
    void setUp() {
        student = new StudentDTO();
        student.setId(1l);
        student.setStudentName("Pepe");

        SubjectDTO subjects = new SubjectDTO();
        subjects.setScore(10d);
        subjects.setName("Literatura");

        SubjectDTO subjects2 = new SubjectDTO();
        subjects2.setScore(2d);
        subjects2.setName("Matematica");

        student.setSubjects(List.of(subjects, subjects2));
    }

    @Test
    void validateScoreIsNotNull() {
        when(repository.findById(student.getId())).thenReturn(student);

        StudentDTO studentExpected = service.analyzeScores(student.getId());

        assertThat(studentExpected).isNotNull();
        assertThat(studentExpected.getStudentName()).isEqualTo("Pepe");
    }

    @Test
    void validateGreetingMessageIsCorrect() {
        when(repository.findById(student.getId())).thenReturn(student);

        StudentDTO studentExpected = service.analyzeScores(student.getId());

        double average = student.getAverageScore();
        String expectedMessage = "El alumno " + student.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");

        assertThat(studentExpected.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void validateAverageScoreIsCorrect() {
        when(repository.findById(student.getId())).thenReturn(student);

        StudentDTO studentExpected = service.analyzeScores(student.getId());

        double averageExpected = student.getSubjects().stream()
                        .mapToDouble(SubjectDTO::getScore)
                        .average()
                        .getAsDouble();

        assertThat(studentExpected.getAverageScore()).isEqualTo(averageExpected);
    }



}