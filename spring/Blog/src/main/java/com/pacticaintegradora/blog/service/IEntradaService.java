package com.pacticaintegradora.blog.service;

import com.pacticaintegradora.blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaService {
    Long nuevaEntrada(EntradaBlog entradaBlog);

    List<EntradaBlog> entradasCreadas();

    EntradaBlog buscarEntrada(Long id);
}
