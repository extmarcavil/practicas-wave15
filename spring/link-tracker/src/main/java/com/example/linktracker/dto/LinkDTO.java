package com.example.linktracker.dto;

import com.example.linktracker.models.Link;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDTO {
    private Integer id;
    private Integer redirects;

    public LinkDTO(Link link) {
        this.id = link.getId();
        this.redirects = link.getRedirects();
    }
}
