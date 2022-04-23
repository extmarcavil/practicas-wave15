package com.pacticaintegradora.blog.repository;

import com.pacticaintegradora.blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaRepository {
    Long nuevaEntrada(EntradaBlog entradaBlog);
    boolean existeEntrada(EntradaBlog entradaBlog);

    List<EntradaBlog> entradasCreadas();

    EntradaBlog buscarEntrada(Long id);
}
