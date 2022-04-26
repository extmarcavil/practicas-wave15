package com.example.linktracker.service;


import com.example.linktracker.DTO.LinkDTO;
import com.example.linktracker.exceptionHandler.BadRequestException;
import com.example.linktracker.exceptionHandler.NotFoundException;
import com.example.linktracker.model.Link;
import com.example.linktracker.repositories.LinkRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.CssLinkResourceTransformer;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkService implements ILinkService {

    LinkRepository linkRepository;
    ModelMapper mm = new ModelMapper();

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Boolean checkLink(String link) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(link);
    }

    @Override
    public Boolean linkExists(String link) {
        return null;
    }

    public Integer saveLink(LinkDTO dto) {
        Link link = mm.map(dto, Link.class);
        if (!this.checkLink(link.getLink())) {
            throw new BadRequestException("La URL enviada es invalida");
        }
        linkRepository.saveLink(link);
        LinkDTO linkDTO = mm.map(link, LinkDTO.class);
        return linkDTO.getId();
    }

    @Override
    public List<LinkDTO> mostrarLinks() {
        List<LinkDTO> listaDtos = linkRepository.mostrarLinks().stream()
                .map(m -> mm.map(m, LinkDTO.class))
                .collect(Collectors.toList());
        return listaDtos;
    }

    @Override
    public String getUrlFromId(Integer id) {
        return linkRepository.getLink(id);
    }


}
