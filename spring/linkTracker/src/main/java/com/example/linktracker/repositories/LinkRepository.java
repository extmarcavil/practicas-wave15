package com.example.linktracker.repositories;

import com.example.linktracker.DTO.LinkDTO;
import com.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository {

    private final Map<Integer, Link> data;

    public LinkRepository() {
        data = new HashMap<>();
    }

    @Override
    public Integer saveLink (Link link) {
        data.put(data.size() + 1, link);
        return link.getId();
    }

    @Override
    public Optional<Link> getLink(Integer id) {
        return data.get(id).getId() == null ? Optional.empty() : Optional.of(data.get(id));
    }

}





