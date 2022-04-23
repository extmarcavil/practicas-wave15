package com.pacticaintegradora.blog.repository;

import com.pacticaintegradora.blog.model.EntradaBlog;
import com.pacticaintegradora.blog.repository.IEntradaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaRepository implements IEntradaRepository {

    private List<EntradaBlog> entradas;

    public EntradaRepository() {
        entradas = new ArrayList<>();
    }

    @Override
    public Long nuevaEntrada(EntradaBlog entradaBlog) {
        entradas.add(entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public boolean existeEntrada(EntradaBlog entradaBlog) {
        for (EntradaBlog e : entradas) {
            if (e.getId().equals(entradaBlog.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<EntradaBlog> entradasCreadas() {
        return entradas;
    }

    @Override
    public EntradaBlog buscarEntrada(Long id) {
        return entradas.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }
}
