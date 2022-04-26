package com.example.linktracker.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LinkDTO {
    private Integer id;
    private String link;
    private Integer count;

    public LinkDTO(Integer id, String link, Integer count) {
        this.id = id;
        this.link = link;
        this.count = count;
    }

    public LinkDTO() {
    }
}
