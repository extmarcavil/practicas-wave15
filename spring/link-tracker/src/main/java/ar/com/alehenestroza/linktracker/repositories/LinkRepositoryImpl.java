package ar.com.alehenestroza.linktracker.repositories;

import ar.com.alehenestroza.linktracker.models.Link;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Getter
@Repository
public class LinkRepositoryImpl implements LinkRepository {
    private final Map<Integer, Link> links;
    private Integer nextId;

    public LinkRepositoryImpl() {
        links = new HashMap<>();
        nextId = 0;
    }

    @Override
    public Integer save(Link link) {
        links.put(++nextId, link);
        return nextId;
    }

    @Override
    public Link get(Integer linkId) {
        return links.get(linkId);
    }

    @Override
    public Integer delete(Integer linkId) {
        return links.remove(linkId).getLinkId();
    }
}
