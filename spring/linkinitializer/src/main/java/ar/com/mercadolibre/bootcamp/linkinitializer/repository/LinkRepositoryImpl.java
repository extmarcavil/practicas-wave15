package ar.com.mercadolibre.bootcamp.linkinitializer.repository;

import ar.com.mercadolibre.bootcamp.linkinitializer.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements LinkRepository{
    private static Long nextId = 0L;
    private List<Link> links = new ArrayList<>();

    @Override
    public Optional<Link> save(String url, String password) {
        if (existsByUrl(url))
            return Optional.empty();

        Link l = new Link();
        l.setId(nextId);
        nextId++;
        l.setUrl(url);
        l.setPassword(password);
        links.add(l);
        return Optional.of(l);
    }

    @Override
    public Optional<Link> findById(Long id) {
        return this.links
                .stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }

    private boolean existsByUrl(String url) {
        return this.links
            .stream()
            .anyMatch(l -> l.getUrl().equals(url));
    }
}
