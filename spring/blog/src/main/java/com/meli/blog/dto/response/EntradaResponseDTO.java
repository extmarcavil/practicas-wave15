package com.meli.blog.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class EntradaResponseDTO {
    private Number id;

    public EntradaResponseDTO(Number id) {
        this.id = id;
    }
}
