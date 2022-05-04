package com.example.be_java_hisp_w15_g05.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {

    @Min(value = 1, message = "El ID del usuario no puede ser menor a 0")
    @NotNull(message = "El ID del usuario no puede estar vacio")
    private int userId;
    @Size(min = 1, max = 15, message = "El nombre debe contener hasta 15 caracteres")
    @NotNull(message = "El nombre del usuario no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z0-9– ].*", message = "El nombre de usuario no debe contener caracteres especiales")
    private String userName;

    public UserDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
