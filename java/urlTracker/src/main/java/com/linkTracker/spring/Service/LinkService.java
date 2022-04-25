package com.linkTracker.spring.Service;

import com.linkTracker.spring.DTO.LinkDTO;
import com.linkTracker.spring.Repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {

    LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public void loadLink(String link) {
        linkRepository.crearLink(link);
    }

    public List<LinkDTO> cargarLink(String link){
        linkRepository.crearLink(link);
        return linkRepository.getLinks();
    }
}
