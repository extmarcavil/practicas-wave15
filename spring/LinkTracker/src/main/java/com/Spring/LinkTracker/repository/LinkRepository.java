package com.Spring.LinkTracker.repository;


import com.Spring.LinkTracker.dto.LinkDTO;
import com.Spring.LinkTracker.exception.UrlAlreadyExists;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository{

    HashMap<Integer, LinkDTO> mapaLinks;
    Integer idCounter;

    public LinkRepository() {
        this.mapaLinks = new HashMap<>();
        this.idCounter = 0;
    }


    @Override
    public Integer saveLink(String url) {
        Collection<LinkDTO> existingLinks = mapaLinks.values();
        for(LinkDTO link : existingLinks){
            if(link.getUrl().equals(url)) return -1;
        }
        LinkDTO newLink = new LinkDTO (url, 0, true);
        idCounter++;
        this.mapaLinks.put(idCounter, newLink);
        return idCounter;
    }

    @Override
    public LinkDTO getURL (Integer id){
        return mapaLinks.get(id);
    }





}
