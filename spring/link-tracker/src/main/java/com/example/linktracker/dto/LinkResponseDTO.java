package com.example.linktracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkResponseDTO {
    private Integer id;
    private Integer redirects;

    public LinkResponseDTO(Integer id) {
        this.id = id;
    }

    public LinkResponseDTO(Integer id, Integer redirects) {
        this(id);
        this.redirects = redirects;
    }
}
