package com.bootcamp.youtuber.service;

import com.bootcamp.youtuber.dto.EntradaBlogDto;
import com.bootcamp.youtuber.entities.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService {

    /**
     * Metodos
     */
    EntradaBlog guardar(EntradaBlogDto entrada);

    List<EntradaBlog> listar();

    EntradaBlog visualizar(Integer id);
}
