package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdDTO {

    int id;

    public IdDTO(int id) {
        this.id = id;
    }
}
