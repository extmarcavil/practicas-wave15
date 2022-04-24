package ar.com.mercadolibre.bootcamp.lfedele.youtuber.repository;

import ar.com.mercadolibre.bootcamp.lfedele.youtuber.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaBlogRepositoryImpl implements EntradaBlogRepository{
    private final List<EntradaBlog> entradas;

    public EntradaBlogRepositoryImpl() {
        this.entradas = new ArrayList<>();
    }

    @Override
    public EntradaBlog save(EntradaBlog entradaBlog) {
        entradas.add(entradaBlog);
        return entradaBlog;
    }

    @Override
    public Optional<EntradaBlog> findById(Long id) {
        return entradas
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public Boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public List<EntradaBlog> findAll() {
        return entradas;
    }
}
