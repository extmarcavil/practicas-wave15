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
    private Integer redirects;

    public Link(URL url, String password) {
        this.url = url;
        this.password = password;
        this.redirects = 0;
    }

    public Link(URL url) {
        this.url = url;
        this.password = "";
        this.redirects = 0;
    }

}
