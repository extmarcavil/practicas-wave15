package com.vparula.links.repositorio;

import com.vparula.links.entidades.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryLink implements IRepositoryLink{
    private int seqLink = 0;
    private Map<Integer,Link> links= new HashMap<>();

    @Override
    public int agregar(Link link) {
        seqLink++;
        link.setId(seqLink);
        links.put(seqLink,link);
        return seqLink;

    }

    @Override
    public Link getLink(Integer id) {
        return links.get(id);
    }

    public boolean hasLink(Integer id){return links.containsKey(id);}
}
