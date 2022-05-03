package com.meli.studenttest.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.meli.studenttest.dto.SubjectDto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

public class RequestStudentDto {

    @JsonProperty("studentName")
    @SerializedName("studentName")
    @NotEmpty(message = "The student name cannot be empty")
    @Pattern(regexp = "^[A-Z].*", message = "The student name must begin with a capital letter")
    @Length(max = 50, message = "The size name cannot greater than 50 characters")
    private final String name;

    @NotEmpty(message = "The list cannot be empty")
    @Valid
    private final List<SubjectDto> subjects;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RequestStudentDto(String name, List<SubjectDto> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<SubjectDto> getSubjects() {
        return subjects;
    }
}
