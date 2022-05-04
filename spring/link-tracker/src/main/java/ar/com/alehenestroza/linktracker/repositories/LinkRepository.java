package ar.com.alehenestroza.linktracker.repositories;

import ar.com.alehenestroza.linktracker.models.Link;

public interface LinkRepository {
    Integer save(Link link);

    Link get(Integer linkId);

    Integer delete(Integer linkId);
}
