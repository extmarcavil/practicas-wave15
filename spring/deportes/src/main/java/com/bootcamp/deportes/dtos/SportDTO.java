package com.bootcamp.deportes.dtos;

import com.bootcamp.deportes.model.Sport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportDTO {
    private  String name;

    public SportDTO(Sport sport) {
        this.name = sport.getName();
    }
}
