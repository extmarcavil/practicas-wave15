package com.youtuber.spring.dto;

import java.io.Serializable;


public class EntradaBlog implements Serializable {
    private Integer id;
    private String entrada;

    public EntradaBlog(Integer id, String entrada) {
        this.id = id;
        this.entrada = entrada;
    }


    public String getEntrada() {
        return entrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
}
