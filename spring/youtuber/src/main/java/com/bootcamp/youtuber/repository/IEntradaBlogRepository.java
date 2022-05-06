package com.bootcamp.youtuber.repository;

import com.bootcamp.youtuber.dto.EntradaBlogDto;
import com.bootcamp.youtuber.entities.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {


    EntradaBlog guardar(EntradaBlog entrada);

    List<EntradaBlog> lista();

    EntradaBlog visualizar(Integer id);

}
