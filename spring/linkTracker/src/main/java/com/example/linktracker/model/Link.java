package com.example.linktracker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Link {
    private Integer id;
    private String link;
    private Integer count;

    public Link(Integer id, String link) {
        this.id = id;
        this.link = link;
        this.count = 0;
    }

    public Link() {
    }
}
