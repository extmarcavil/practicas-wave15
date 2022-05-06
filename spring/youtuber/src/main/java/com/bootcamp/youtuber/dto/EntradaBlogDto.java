package com.bootcamp.youtuber.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EntradaBlogDto {

    /**
     * Atributos
     */
    private Integer id;
    private String titulo;
    private String nombreAutor;

}
