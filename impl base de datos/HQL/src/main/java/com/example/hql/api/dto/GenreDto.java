package com.example.hql.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class GenreDto implements Serializable {
    private final Integer id;
    private final String name;
}
