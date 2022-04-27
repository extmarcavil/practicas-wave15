package com.linkTracker.spring.Service;

import com.linkTracker.spring.DTO.LinkDTO;
import com.linkTracker.spring.Repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    @Autowired
    LinkRepository linkRepository;

    public LinkDTO createLink(String link) {


        return linkRepository.crearLink(link);

    }
}
