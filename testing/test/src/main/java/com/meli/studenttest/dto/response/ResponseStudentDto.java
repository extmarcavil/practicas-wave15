package com.meli.studenttest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.studenttest.dto.SubjectDto;
import io.vavr.Tuple2;

import java.util.List;
import java.util.Objects;

public class ResponseStudentDto {

    private Long id;

    @JsonProperty("studentName")
    private final String name;

    private final String message;
    private final Double averageScore;
    private final List<SubjectDto> subjects;

    public ResponseStudentDto(Long id, String name, String message, Double averageScore, List<SubjectDto> subjects) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.averageScore = averageScore;
        this.subjects = subjects;
    }

    public ResponseStudentDto(String name, String message, Double averageScore, List<SubjectDto> subjects) {
        this.name = name;
        this.message = message;
        this.averageScore = averageScore;
        this.subjects = subjects;
    }

    public static ResponseStudentDto from(String name, Tuple2<Double, List<SubjectDto>> dataCourses) {
        Double averageScore = dataCourses._1();
        String message = String.format("The student %s got average of %s ", name, averageScore);

        return new ResponseStudentDto(name, message, averageScore, dataCourses._2());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseStudentDto that = (ResponseStudentDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(message, that.message)
                && Objects.equals(averageScore, that.averageScore)
                && Objects.equals(subjects, that.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, message, averageScore, subjects);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public List<SubjectDto> getSubjects() {
        return subjects;
    }
}
