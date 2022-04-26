package com.example.linktracker.services;

import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.exceptions.InvalidPasswordException;
import com.example.linktracker.exceptions.InvalidURLException;
import com.example.linktracker.exceptions.LinkNotFoundException;
import com.example.linktracker.models.Link;
import com.example.linktracker.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;

    @Override
    public Integer save(String url, String password) {
        URL linkUrl;
        try {
            linkUrl = new URL(url);
        } catch (Exception e) {
            throw new InvalidURLException("URL invalida.");
        }
        return this.linkRepository.save(linkUrl, password);
    }

    @Override
    public URL redirect(Integer id, String password) {
        Link link = this.linkRepository.getLink(id);
        link.newRedirect();
        if (link == null) {
            throw new LinkNotFoundException("No se encontro un link con ese ID.");
        }
        if ( !link.getPassword().equals(password)) {
            throw new InvalidPasswordException("La contraseña es invalida.");
        }
        return link.getUrl();
    }

    @Override
    public LinkDTO getStatistics(Integer id) {
        Link link = this.linkRepository.getLink(id);
        if (link == null) {
            throw new LinkNotFoundException("No se encontro un link con ese ID.");
        }
        return new LinkDTO(link);
    }

    @Override
    public void invalidate(Integer id) {
        this.linkRepository.invalidate(id);
    }
}
