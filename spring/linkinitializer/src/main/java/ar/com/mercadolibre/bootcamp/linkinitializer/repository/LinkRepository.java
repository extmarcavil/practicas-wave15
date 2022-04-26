package ar.com.mercadolibre.bootcamp.linkinitializer.repository;

import ar.com.mercadolibre.bootcamp.linkinitializer.model.Link;

import java.util.Optional;

public interface LinkRepository {
    Optional<Link> save(String link, String passord);
    Optional<Link> findById(Long id);
}
