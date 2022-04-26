package com.example.linktracker.repository;

import com.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {
    private List<Link> links;
    private int currentId;

    public LinkTrackerRepository() {
        this.currentId = 1;
        this.links = new ArrayList<>();
    }

    @Override
    public int createLink(String url) {
        Link link = new Link(currentId++, url, true);
        links.add(link);
        return link.getId();
    }
}
