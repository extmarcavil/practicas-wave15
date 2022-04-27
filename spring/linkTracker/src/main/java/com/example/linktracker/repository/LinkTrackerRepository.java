package com.example.linktracker.repository;

import com.example.linktracker.exceptions.NotFoundException;
import com.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {
    private List<Link> links;
    private int currentId;

    public LinkTrackerRepository() {
        this.links = new ArrayList<>();
        this.currentId = 1;
    }

    @Override
    public int createLink(String url, String password) {
        Link link = new Link(currentId++, url, password);
        links.add(link);
        return link.getId();
    }

    @Override
    public String getLink(int id, String password) {
        Optional<Link> optional = findLinkWithPassword(id, password);
        if (optional.isEmpty()){
            throw new NotFoundException("No se encontró la url con el id y password especificados.");
        }
        Link link = optional.get();
        link.setMetrics(link.getMetrics() + 1);
        return link.getUrl();
    }

    @Override
    public int getMetrics(Integer id) {
        return findLinkById(id).getMetrics();
    }

    @Override
    public void invalidateLink(Integer id) {
        findLinkById(id).setActive(false);
    }

    private Link findLinkById(int id) {
        return links.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .get();
    }

    private Optional<Link> findLinkWithPassword(int id, String password){
        return links.stream()
                .filter(v -> v.getId() == id && v.getPassword().equals(password))
                .findFirst();
    }
}
