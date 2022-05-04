package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank @Pattern(regexp = "^[A-Z]*") @Max(50)
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty
    List<SubjectDTO> subjects;
}
