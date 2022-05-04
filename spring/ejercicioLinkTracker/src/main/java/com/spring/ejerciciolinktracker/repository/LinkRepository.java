package com.spring.ejerciciolinktracker.repository;

import com.spring.ejerciciolinktracker.dto.Link;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LinkRepository implements ILinkRepository {

    private List<Link> data;

    public LinkRepository(List<Link> data) {
        this.initData();
    }

    private void initData() {
        this.data = new ArrayList<>();
        data.add(new Link(trackUrl(), "www.facebook.com"));
        data.add(new Link(trackUrl(), "www.youtube.com"));
    }

    @Override
    public String createLink(String url) {
        String urlTracked = this.trackUrl();
        Link link = new Link(urlTracked, url);
        data.add(link);
        return urlTracked;
    }

    @Override
    public Optional<Link> getUrlRedirect(String linkId) {
        return data.stream()
                .filter(link -> link.getLinkId().equals(linkId))
                .findFirst();
    }

    private String trackUrl() {
        StringBuilder urlTracked = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            urlTracked.append((char) (random.nextInt(26) + 'a'));
        }
        return urlTracked.toString();
    }
}
