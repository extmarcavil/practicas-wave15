package com.example.linktracker.models;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class Link {
    private Integer id; // DTO
    private URL url;
    private String password;
    private Integer redirects = 0;

    public Link(Integer id, URL url, String password) {
        this.id = id;
        this.url = url;
        this.password = password;
    }
}
