package com.example.linkpractice.repository;

import com.example.linkpractice.exceptions.NotFoundException;
import com.example.linkpractice.models.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements IRepository {

    private HashMap<Integer, Link> links = new HashMap<>();
    private Integer proxID = 1;

    @Override
    public Integer saveLink(Link link) {
        link.setId(proxID);
        links.put(proxID, link);
        proxID++;
        return link.getId();
    }

    @Override
    public Link getLink(Integer id) {
        Link link = links.getOrDefault(id, null);

        if(link == null)
            throw new NotFoundException("No se ha encontrado el link con el id: " + id);

        return link;
    }
}
