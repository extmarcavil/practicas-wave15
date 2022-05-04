package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty @Pattern(regexp = "^[A-Z]*") @Max(30)
    String name;
    @NotNull @DecimalMin("0.0") @DecimalMax("10.0")
    Double score;
}
