package com.example.linktracker.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class LinkDTO {
    private Integer id;
    private String link;
    private Integer count;
}
