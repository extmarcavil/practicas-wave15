package com.example.linktracker.services;

import com.example.linktracker.dto.RequestDTO;
import com.example.linktracker.dto.ResponseDTO;
import com.example.linktracker.exceptions.InvalidPasswordException;
import com.example.linktracker.exceptions.LinkNotFoundException;
import com.example.linktracker.models.Link;
import com.example.linktracker.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;

    @Override
    public ResponseDTO save(RequestDTO link) {
        Link newLink = new Link(link.getUrl(), link.getPassword());
        return new ResponseDTO(linkRepository.save(newLink));
    }

    @Override
    public void invalidate(Integer idLink) {
        this.linkRepository.invalidate(idLink);
    }

    private Link findLink(Integer linkId) {
        Link link = linkRepository.getLink(linkId);
        if (link == null) {
            throw new LinkNotFoundException("No existe un link con ese ID.");
        }
        return link;
    }

    @Override
    public String getUrl(Integer linkId, String password) {
        Link link = findLink(linkId);
        if (!link.getPassword().equals(password)) {
            throw new InvalidPasswordException("La contraseña es inválida.");
        }
        return link.getUrl().toString();
    }

    @Override
    public ResponseDTO getMetrics(Integer linkId) {
        Link link = findLink(linkId);
        return new ResponseDTO(link.getRedirects());
    }


}
