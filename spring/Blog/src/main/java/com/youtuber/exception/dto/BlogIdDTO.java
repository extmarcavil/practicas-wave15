package com.youtuber.exception.dto;

import lombok.Getter;

@Getter
public class BlogIdDTO {

    private Integer id;


    public BlogIdDTO(Integer id) {
        this.id = id;
    }
}
