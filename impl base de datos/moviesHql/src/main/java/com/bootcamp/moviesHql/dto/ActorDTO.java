package com.bootcamp.moviesHql.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Double rating;

}
