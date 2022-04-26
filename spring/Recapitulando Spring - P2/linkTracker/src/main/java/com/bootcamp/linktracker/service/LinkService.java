package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dtos.LinkDTO;
import com.bootcamp.linktracker.exception.NotFoundException;
import com.bootcamp.linktracker.exception.UnauthorizedException;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.ILinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class LinkService  implements ILinkService{

    private ILinkRepository linkRepository;
    private ModelMapper mapper;

    public LinkService(ILinkRepository linkRepository){
        this.linkRepository = linkRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public Integer save(LinkDTO link) {
        try {
            new URL(link.getUrl()).toURI();
            Link l = mapper.map(link, Link.class);
            l.setEnable(true);
            l.setCount(0);
            return linkRepository.save(l);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new IllegalArgumentException(link.getUrl());
        }

    }

    @Override
    public String getLink(Integer id, String password) {

        Link link = linkRepository.getLink(id);

        if(!link.getPassword().equals(password)){
            throw new UnauthorizedException("Password invalido");
        }

        if(!link.getEnable()){
            throw new NotFoundException(link.getUrl());
        }

        link.setCount(link.getCount() + 1);

        linkRepository.update(link);
        return link.getUrl();
    }

    @Override
    public Integer getCount(Integer id) {
        return linkRepository.getCount(id);
    }

    @Override
    public LinkDTO invalidate(Integer id) {
        return mapper.map(linkRepository.invalidate(id), LinkDTO.class);
    }

}
