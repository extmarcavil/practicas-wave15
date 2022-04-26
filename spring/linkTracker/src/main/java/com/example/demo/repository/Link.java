package com.example.demo.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link {

    String url;
    int estadistica;
    Boolean status;
    int id;

    public Link(String link) {
        this.url = link;
        this.estadistica = 0;
        this.status = true;
    }
}
