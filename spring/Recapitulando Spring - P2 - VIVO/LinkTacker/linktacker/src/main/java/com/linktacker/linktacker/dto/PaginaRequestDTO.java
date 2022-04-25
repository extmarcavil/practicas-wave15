package com.linktacker.linktacker.dto;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.net.URL;

@Getter
@Setter
public class PaginaRequestDTO implements Serializable {
    private URL url;
    private String password;

    public PaginaRequestDTO(){

    }
}
