package com.Spring.LinkTracker.repository;


import com.Spring.LinkTracker.dto.LinkDTO;
import org.springframework.stereotype.Repository;

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
        LinkDTO newLink = new LinkDTO (url, 0, true);
        idCounter++;
        this.mapaLinks.put(idCounter, newLink);
        return idCounter;
    }

    @Override
    public String getUrl (Integer id){
        return mapaLinks.get(id).getUrl();
    }

}
