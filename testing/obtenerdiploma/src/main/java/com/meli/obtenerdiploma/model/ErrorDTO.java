package com.meli.obtenerdiploma.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    String name;
    String description;

    public ErrorDTO() {
    }

    public ErrorDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
