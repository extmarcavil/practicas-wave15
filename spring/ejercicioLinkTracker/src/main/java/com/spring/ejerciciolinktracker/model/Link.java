package com.spring.ejerciciolinktracker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link {
    private Long id;
    private String url;
    private Integer contador;
}
