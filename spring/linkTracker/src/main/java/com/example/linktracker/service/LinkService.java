package com.example.linktracker.service;


import com.example.linktracker.repositories.LinkRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.CssLinkResourceTransformer;

@Service
public class LinkService implements ILinkService {

    LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Boolean checkLink(String link) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(link);
    }

    public Boolean linkExists(String link) {


    }


}
