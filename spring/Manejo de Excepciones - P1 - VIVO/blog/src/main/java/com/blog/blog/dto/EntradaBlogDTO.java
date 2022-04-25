package com.blog.blog.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO {
    private Long id;
    private String titulo;
    private String autor;
    private Date fecha;
}
