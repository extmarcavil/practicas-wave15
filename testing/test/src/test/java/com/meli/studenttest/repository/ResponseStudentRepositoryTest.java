package com.meli.studenttest.repository;

import com.meli.studenttest.dto.response.ResponseStudentDto;
import com.meli.studenttest.exception.StudentAlreadyExistsException;
import com.meli.studenttest.exception.StudentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
class ResponseStudentRepositoryTest {

    private static final Long NONEXISTENT_ID = 10L;

    @Autowired
    private ResponseStudentRepository repository;

    private ResponseStudentDto studentDto;

    @BeforeEach
    void setUp() {
        studentDto =  new ResponseStudentDto(1L, "Pepe", "Nothing", 5D, emptyList());
        repository.reload();
    }

    @Test
    void whenTheStudentAlreadyExists_thenAnExceptionIsThrown() {
        assertThatThrownBy(() -> repository.save(studentDto))
                .isInstanceOf(StudentAlreadyExistsException.class)
                .hasMessage("Student with ID %s already exists.", studentDto.getId());
    }

    @Test
    void whenTheStudentDoesNotExist_thenItsSavedCorrectly() {
        long repositorySizeBefore = repository.findAll().size();
        ResponseStudentDto response =
                new ResponseStudentDto(3L, "Pepe 2", "Nothing", 5D, emptyList());

        repository.save(response);
        long repositorySizeAfter = repository.findAll().size();

        assertThat(repository.findById(response.getId())).isNotNull();
        assertThat(repositorySizeAfter).isEqualTo(repositorySizeBefore+1);
    }

    @Test
    void whenYouWantToDeleteAnUserDoesNotExist_thenTheFalseIsReturned() {
        assertThat(repository.delete(NONEXISTENT_ID)).isFalse();
    }

    @Test
    void whenYouWantToDeleteAnUserExists_thenTheTrueIsReturned() {
        assertThat(repository.delete(studentDto.getId())).isTrue();
    }

    @Test
    void whenYouWantToUpdateAnUserButDoesNotExist_thenAnExceptionIsThrown() {
        assertThatThrownBy(() -> repository.findByIdForUpdate(NONEXISTENT_ID, ignore -> {}))
                .isInstanceOf(StudentNotFoundException.class)
                .hasMessage(String.format("Student with ID %s wasn't found", NONEXISTENT_ID));
    }

    @Test
    void whenLookingForAnUserThatDoesNotExist_thenAnEmptyOptionalIsReturned() {
        assertThat(repository.findById(NONEXISTENT_ID)).isNotPresent();
    }
}