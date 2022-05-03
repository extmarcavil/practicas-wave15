package com.meli.studenttest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class SubjectDto {

    @NotEmpty(message = "The name of course cannot be empty")
    @Pattern(regexp = "^[A-Z].*", message = "The name of course must begin with a capital letter")
    @Length(max = 30, message = "The size name cannot greater than 30 characters")
    private final String name;

    @NotNull
    @DecimalMin(value = "0.0", message = "The score min is 0.0")
    @DecimalMax(value = "10.0", message = "The score max is 10.0")
    private final Double score;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public SubjectDto(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }
}
