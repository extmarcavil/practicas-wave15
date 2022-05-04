package com.sprint1.be_java_hisp_w15_g03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    @NotNull(message = "El  id no puede estar vacío.")
    private Integer userId;
    @Size(max = 15, message = "Nombre de usuario debe ser menor a 15 caracteres.")
    private String userName;

}
