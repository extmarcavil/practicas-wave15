package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.exception.NotFoundException;
import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Objects;

@Repository
public class LinkRepository implements ILinkRepository{

    private HashMap<Integer, Link>  database;

    public LinkRepository(){
        database = new HashMap<>();
    }


    @Override
    public Integer save(Link link) {
        Integer id = database.size() + 1;
        link.setId(id);
        database.put(id, link);
        return id;
    }

    @Override
    public Link getLink(Integer id) {
        if(database.containsKey(id)){
            return database.get(id);
        }
        throw new NotFoundException("No existe el recurso");
    }

    @Override
    public Integer getCount(Integer id) {
        return database.values().stream()
                .filter(l -> Objects.equals(l.getId(), id))
                .map(Link::getCount)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Link invalidate(Integer id) {
        if(database.containsKey(id)){
            Link link = database.get(id);
            link.setEnable(false);
            database.put(link.getId(), link);
            return link;
        }
        throw new NotFoundException("No existe el recurso");
    }

    @Override
    public void update(Link link){
        database.put(link.getId(), link);
    }
}
