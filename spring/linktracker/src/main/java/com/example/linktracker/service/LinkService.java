package com.example.linktracker.service;

import com.example.linktracker.dto.RequestLinkDTO;
import com.example.linktracker.dto.ResponseLinkDTO;
import com.example.linktracker.model.Link;
import com.example.linktracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

// crear exepciones personalizadas
//Estadisticas por link
//Invalidar link
//Agregar password por link (?)
@Service
public class LinkService implements ILinkService{
    // atributos
    private ILinkRepository linkRepository;

    // constructor
    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    // metodos
    @Override
    public ResponseLinkDTO create(RequestLinkDTO req) {
        // validación de url
        try {
            new URL(req.getUrl()).toURI();
        } catch (URISyntaxException | MalformedURLException exception) {
            /*return false;*/
            System.out.println(exception.getMessage());
            throw new RuntimeException();
        }

        // agrega url a repositorio
        Link link = new Link(req.getUrl(),true);
        int index = linkRepository.create(link);

        return new ResponseLinkDTO(index);
    }

    @Override
    public String findByIndex(int index) {
        //tenian razon, habia que restarle uno xd
        Link linkResp =  linkRepository.findByIndex(index - 1);

        //corroborar que venga vacio, se puede hacer mejor
        if (linkResp.getUrl() == null){
            throw new RuntimeException("FEO");
        }

        return linkResp.getUrl();
    }
}
