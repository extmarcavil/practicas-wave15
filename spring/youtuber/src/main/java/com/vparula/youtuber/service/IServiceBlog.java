package com.vparula.youtuber.service;

import com.vparula.youtuber.dto.EntradaDTO;
import com.vparula.youtuber.model.EntradaBlog;

import java.util.List;

public interface IServiceBlog {
    public void agregarBlog(EntradaDTO blog);
    public EntradaDTO getEntrada(int entrada);
    public List<EntradaDTO> obtenerEntradas();
}
