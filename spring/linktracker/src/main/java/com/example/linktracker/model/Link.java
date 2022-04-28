package com.example.linktracker.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Link {
    private String url;
    private boolean validated;

    public Link(String url, boolean validated) {
        this.url = url;
        this.validated = validated;
    }

    public Link() {}
}
