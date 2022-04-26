package com.example.linktracker.repositories;

import com.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LinkRepository implements ILinkRepository {

    private final Map<Integer, Link> data;

    public LinkRepository() {
        data = new HashMap<>();
    }

    @Override
    public Link saveLink (Link link) {
        data.put(data.size() + 1, link);
        return link;
    }

    @Override
    public String getLink(Integer id) {
        Link link= data.values()
                .stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .get();
        link.setCount(link.getCount()+1);
        return link.getLink();
    }

    @Override
    public List<Link> mostrarLinks() {
        return data.values().stream().collect(Collectors.toList());
    }

}





