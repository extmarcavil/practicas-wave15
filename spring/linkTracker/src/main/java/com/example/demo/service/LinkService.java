package com.example.demo.service;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.LinkDTO;
import com.example.demo.repository.Link;
import com.example.demo.repository.LinkRepository;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//www\.([a-z]+)\.([a-z]{2,3}).*
@Service
public class LinkService {

    LinkRepository repository;

    public LinkService(LinkRepository repository) {
        this.repository = repository;
    }

    public IdDTO addLink(LinkDTO linkDTO){

        String URL_REGEX =
                "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                        "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                        "([).!';/?:,][[:blank:]])?$";

        Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
        Matcher matcher = URL_PATTERN.matcher(linkDTO.getUrl());
        if (!matcher.matches()){
            throw new RuntimeException("URL no valido.");
        }

        Link link = new Link(linkDTO.getUrl());
        IdDTO idDTO = new IdDTO(repository.addLink(link));
        return idDTO;
    }

    public String getURLByID(int id){
        Link link = repository.findURLByID(id);

        if(link == null){
            throw new RuntimeException("ID no valido.");
        }
        repository.incrementarEstadistica(link);
        return link.getUrl();
    }
    
}
