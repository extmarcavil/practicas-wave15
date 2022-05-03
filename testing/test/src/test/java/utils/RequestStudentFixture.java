package utils;

import com.meli.studenttest.dto.SubjectDto;
import com.meli.studenttest.dto.request.RequestStudentDto;

import java.util.List;

import static java.util.Collections.emptyList;

public class RequestStudentFixture {

    private static final String NAME_50_CHARACTERS = "Addddddddddddddddddddddddddddddddddddddddddddddddddd";
    private static final String SUBJECT_NAME_CORRECT = "Mathematical";
    public static final String STUDENT_NAME_CORRECT = "Pepe";
    public static final List<SubjectDto> SUBJECT_VALID = List.of(aSubjectDtoCorrect());

    public static SubjectDto aSubjectDtoCorrect() {
        return new SubjectDto("Literature", 5.5);
    }

    public static RequestStudentDto studentDtoCorrect() {
        return new RequestStudentDto(STUDENT_NAME_CORRECT, SUBJECT_VALID);
    }

    public static RequestStudentDto createRequestStudentDtoWithSubjectInvalid(SubjectDto subjectDtoInvalid) {
        return new RequestStudentDto(STUDENT_NAME_CORRECT, List.of(subjectDtoInvalid));
    }

    public static RequestStudentDto studentWithEmptyName() {
        return new RequestStudentDto("", SUBJECT_VALID);
    }

    public static RequestStudentDto studentWithoutCapitalLetter() {
        return new RequestStudentDto("alfonso", SUBJECT_VALID);
    }

    public static RequestStudentDto studentWithNameMoreThan50Characters() {
        return new RequestStudentDto(NAME_50_CHARACTERS, SUBJECT_VALID);
    }

    public static RequestStudentDto studentWithEmptyList() {
        return new RequestStudentDto(STUDENT_NAME_CORRECT, emptyList());
    }

    public static SubjectDto subjectDtoWithEmptyName() {
        return new SubjectDto("", 10.0);
    }

    public static SubjectDto subjectDtoWithoutCapitalLetter() {
        return new SubjectDto("mathematical", 10.0);
    }

    public static SubjectDto subjectDtoWithScoreLessThanZero() {
        return new SubjectDto(SUBJECT_NAME_CORRECT, -1);
    }

    public static SubjectDto subjectDtoWithNameMoreThan30Characters() {
        return new SubjectDto(NAME_50_CHARACTERS, 9);
    }

    public static SubjectDto subjectDtoWithScoreGreaterThanTen() {
        return new SubjectDto(SUBJECT_NAME_CORRECT, 11);
    }
}
