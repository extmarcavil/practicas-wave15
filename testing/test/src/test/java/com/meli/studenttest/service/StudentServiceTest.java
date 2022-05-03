package com.meli.studenttest.service;

import com.meli.studenttest.dto.SubjectDto;
import com.meli.studenttest.dto.request.RequestStudentDto;
import com.meli.studenttest.dto.response.ResponseStudentDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.RequestStudentFixture.studentDtoCorrect;
import static utils.RequestStudentFixture.studentWithEmptyList;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService service;

    @BeforeEach
    void setUp() {
        // ...
    }

    @Test
    void whenTheRequestIsCorrect_thenTheResponseDtoIsReturned() {
        RequestStudentDto studentDto = studentDtoCorrect();

        ResponseStudentDto response = service.calculateAverage(studentDto);
        double scoreExpected = calculateAverageScoreFrom(studentDto.getSubjects());
        String expectedMessage = String.format("The student %s got average of %s ", studentDto.getName(), scoreExpected);

        assertThat(response.getName()).isEqualTo(studentDto.getName());
        assertThat(response.getSubjects()).usingRecursiveComparison().isEqualTo(studentDto.getSubjects());
        assertThat(response.getMessage()).isEqualTo(expectedMessage);
        assertThat(response.getAverageScore()).isEqualTo(scoreExpected);
    }

    @Test
    void whenTheRequestDoesNotHaveSubjects_thenTheAverageScoreIsZero() {
        RequestStudentDto studentDtoWithoutSubjects = studentWithEmptyList();

        ResponseStudentDto responseStudentDto = service.calculateAverage(studentDtoWithoutSubjects);

        assertThat(responseStudentDto.getAverageScore()).isEqualTo(0);
    }

    private double calculateAverageScoreFrom(List<SubjectDto> subjects) {
        return subjects.stream()
                .mapToDouble(SubjectDto::getScore)
                .average()
                .orElse(0);
    }

}