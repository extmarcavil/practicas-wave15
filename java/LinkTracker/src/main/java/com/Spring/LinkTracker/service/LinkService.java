package com.Spring.LinkTracker.service;


import com.Spring.LinkTracker.dto.LinkDTO;
import com.Spring.LinkTracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class LinkService implements ILinkService{

    ILinkRepository repository;

    public LinkService(ILinkRepository repository) {
        this.repository = repository;
    }


    @Override
    public Integer saveLink(String url) {
        return this.repository.saveLink(url);
    }

    @Override
    public String getURL(Integer id) {
        String url = this.repository.getUrl(id);
        try {
            new URL(url).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
