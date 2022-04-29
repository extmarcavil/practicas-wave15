package com.meli.obtenerdiploma.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDTO {
    private String name;
    private List<FieldErrorDTO> fields;
}
