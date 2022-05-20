package com.bootcamp.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenreDTO {
    private Integer id;
    private Instant createdAt;
    private Instant updatedAt;
    private String name;
    private Integer ranking;
    private Boolean active = false;
}