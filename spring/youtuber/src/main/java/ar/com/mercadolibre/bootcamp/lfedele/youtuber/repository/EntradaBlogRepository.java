package ar.com.mercadolibre.bootcamp.lfedele.youtuber.repository;

import ar.com.mercadolibre.bootcamp.lfedele.youtuber.model.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface EntradaBlogRepository {
    EntradaBlog save(EntradaBlog entradaBlog);
    Optional<EntradaBlog> findById(Long id);
    Boolean existsById(Long id);
    List<EntradaBlog> findAll();
}
