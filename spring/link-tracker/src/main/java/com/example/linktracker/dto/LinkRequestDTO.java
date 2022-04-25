package com.example.linktracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkRequestDTO {
    private String id;
    private String url;
    private String password;

    public LinkRequestDTO(String url, String password) {
        this.url = url;
        this.password = password;
    }
}
