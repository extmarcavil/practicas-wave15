package com.bootcamp.youtuber.repository;

import com.bootcamp.youtuber.dto.EntradaBlogDto;
import com.bootcamp.youtuber.entities.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepositoryImpl implements IEntradaBlogRepository {

    /**
     * Almacenamiento en memoria
     */
    List<EntradaBlog> blogBd = new ArrayList<>();

    /**
     * Metodos Repository
     */
    @Override
    public EntradaBlog guardar(EntradaBlog entrada) {
        blogBd.add(entrada);

        return entrada;
    }

    @Override
    public List<EntradaBlog> lista() {
        return blogBd;
    }

    @Override
    public EntradaBlog visualizar(Integer id) {
        return blogBd.stream()
                .filter(blog -> blog.getId().equals(id)).findFirst().get();
    }


}
