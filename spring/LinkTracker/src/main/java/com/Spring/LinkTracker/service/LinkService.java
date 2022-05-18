package com.Spring.LinkTracker.service;


import com.Spring.LinkTracker.dto.LinkDTO;
import com.Spring.LinkTracker.exception.IdNotFound;
import com.Spring.LinkTracker.exception.LinkAlreadyInvalidated;
import com.Spring.LinkTracker.exception.UrlAlreadyExists;
import com.Spring.LinkTracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    ILinkRepository repository;

    public LinkService(ILinkRepository repository) {
        this.repository = repository;
    }


    @Override
    public Integer saveLink(String url) {
        Integer linkId = repository.saveLink(url);
        if(linkId == -1) throw new UrlAlreadyExists(url);
        return linkId;
    }

    @Override
    public LinkDTO getURL(Integer id) {
        LinkDTO webpage = repository.getURL(id);
        if(webpage == null) throw new IdNotFound(id);
        else return webpage;
    }

    @Override
    public LinkDTO redirect(Integer id) {
        LinkDTO webpage = getURL(id);
        Integer redirections = webpage.getContadorRedirecciones();
        redirections++;
        webpage.setContadorRedirecciones(redirections);
        return webpage;
    }

    @Override
    public Integer metrics(Integer id) {
        return getURL(id).getContadorRedirecciones();
    }

    @Override
    public void invalidate(Integer id) {
        LinkDTO webpage = getURL(id);
        if(!webpage.isActivo()) throw new LinkAlreadyInvalidated(id);
        else webpage.setActivo(false);
    }


}
