package com.spring.ejerciciolinktracker.service;

import com.spring.ejerciciolinktracker.dto.Link;
import com.spring.ejerciciolinktracker.exception.NotFoundException;
import com.spring.ejerciciolinktracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService implements ILinkService {

    private final ILinkRepository linkRepo;


    public LinkService(ILinkRepository linkRepo) {
        this.linkRepo = linkRepo;
    }


    @Override
    public String createLink(String url) {
        return linkRepo.createLink(url);
    }

    @Override
    public String getLinkRedirect(String linkId) {
        Optional<Link> linkTrack = linkRepo.getUrlRedirect(linkId);
        if (linkTrack.orElse(null) == null) {
            throw new NotFoundException("No se encontro el linkid: " + linkId);
        }
        Link link = ;
        System.out.println(link);
        return linkTrack.get().getUrl();
    }
}
