package com.meli.studenttest.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.meli.studenttest.dto.SubjectDto;
import com.meli.studenttest.dto.request.RequestStudentDto;
import com.meli.studenttest.dto.response.ResponseStudentDto;
import com.meli.studenttest.service.StudentService;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static utils.RequestStudentFixture.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    private static final String API = "/student";
    private static final String AVERAGE_POST = String.format(API+"/%s", "average");

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MockMvc mockApiRest;

    @Mock
    private StudentService studentService;

    private StudentController controller;
    private Gson mapper;
    private RequestStudentDto studentDto;

    @BeforeEach
    void setUp() {
        controller = new StudentController(studentService);
        mockApiRest = webAppContextSetup(webApplicationContext).build();
        mapper = new GsonBuilder().create();
        studentDto = studentDtoCorrect();
    }

    @Test
    void whenTheRequestIsValid_thenTheResponseIsReturned() {
        when(studentService.calculateAverage(studentDto)).thenReturn(createResponseFrom(studentDto));

        ResponseStudentDto response = controller.studentAverage(studentDto);

        verify(studentService, atLeastOnce()).calculateAverage(studentDto);

        String nameExpected = studentDto.getName();

        assertThat(response.getName()).isEqualTo(nameExpected);
        assertThat(response.getMessage()).contains(String.format("The student %s got average of", nameExpected));
        assertThat(response.getSubjects()).usingRecursiveComparison().isEqualTo(studentDto.getSubjects());
        assertThat(response.getAverageScore()).isEqualTo(5.5);
    }

    @ParameterizedTest
    @MethodSource("invalidFields")
    void whenTheFieldsAreInvalid_thenAnExceptionIsThrown(RequestStudentDto studentDto, String errorMessage) {
        makeRequestAndAssertResponse(studentDto, errorMessage);

        verify(studentService, never()).calculateAverage(any());
    }

    public static Stream<Arguments> invalidFields() {
        return Stream.of(
                Arguments.of(studentWithEmptyName(), "The student name cannot be empty"),
                Arguments.of(studentWithoutCapitalLetter(), "The student name must begin with a capital letter"),
                Arguments.of(studentWithNameMoreThan50Characters(), "The size name cannot greater than 50 characters"),
                Arguments.of(studentWithEmptyList(), "The list cannot be empty")
        );
    }

    @ParameterizedTest
    @MethodSource("subjectFieldsInvalid")
    void whenTheSubjectFieldsAreInvalid_thenAnExceptionIsThrown(RequestStudentDto studentDto, String errorMessage) {
        makeRequestAndAssertResponse(studentDto, errorMessage);

        verify(studentService, never()).calculateAverage(any());
    }

    public static Stream<Arguments> subjectFieldsInvalid() {
        return Stream.of(
                Arguments.of(createRequestStudentDtoWithSubjectInvalid(subjectDtoWithEmptyName()),
                        "The name of course cannot be empty"),
                Arguments.of(createRequestStudentDtoWithSubjectInvalid(subjectDtoWithoutCapitalLetter()),
                        "The name of course must begin with a capital letter"),
                Arguments.of(createRequestStudentDtoWithSubjectInvalid(subjectDtoWithNameMoreThan30Characters()),
                        "The size name cannot greater than 30 characters"),
                Arguments.of(createRequestStudentDtoWithSubjectInvalid(subjectDtoWithScoreLessThanZero()),
                        "The score min is 0.0"),
                Arguments.of(createRequestStudentDtoWithSubjectInvalid(subjectDtoWithScoreGreaterThanTen()),
                        "The score max is 10.0")
        );
    }

    private <T> String toJson(T object) {
        return mapper.toJson(object);
    }

    private void makeRequestAndAssertResponse(RequestStudentDto studentDto, String errorMessage) {
        try {
            mockApiRest.perform(post(AVERAGE_POST)
                            .contentType(APPLICATION_JSON)
                            .content(toJson(studentDto)))
                    .andExpect(status().isBadRequest())
                    .andExpect(error -> {
                        Exception ex = error.getResolvedException();
                        assertThat(ex instanceof MethodArgumentNotValidException).isTrue();
                        assertThat(ex).hasMessageContaining(errorMessage);
                    });
        } catch (Exception ignore) {}
    }

    private ResponseStudentDto createResponseFrom(RequestStudentDto studentDto) {
        return ResponseStudentDto.from(studentDto.getName(), calculateAverageScoreFrom(studentDto.getSubjects()));
    }

    private Tuple2<Double, List<SubjectDto>> calculateAverageScoreFrom(List<SubjectDto> subjects) {
        return Tuple.of(subjects.stream()
                .mapToDouble(SubjectDto::getScore)
                .average()
                .orElse(0), subjects);
    }

}