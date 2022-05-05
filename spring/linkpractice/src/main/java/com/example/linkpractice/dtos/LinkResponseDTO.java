package com.example.linkpractice.dtos;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class LinkResponseDTO implements Serializable {
    Integer linkId;

    public LinkResponseDTO(Integer linkId) {
        this.linkId = linkId;
    }
}
