package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDTO {

    String url;

    public LinkDTO(String url) {
        this.url = url;
    }
}
