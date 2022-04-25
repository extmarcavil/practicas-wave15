package com.vparula.youtuber.repository;

import com.vparula.youtuber.model.EntradaBlog;

import java.util.List;

public interface IRepositoryBlog {
    public void agregarEntrada(EntradaBlog entrada);
    public EntradaBlog obtenerEntrada(int entrada);
    public List<EntradaBlog> obtenerEntradas();
    public boolean existeId(int id);

}
