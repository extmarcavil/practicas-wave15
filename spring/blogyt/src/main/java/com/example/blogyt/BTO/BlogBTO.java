package com.example.blogyt.BTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class BlogBTO {
    int id;
    String titulo;
    String nombreAutor;
    Date fechaPublicacion;

}
