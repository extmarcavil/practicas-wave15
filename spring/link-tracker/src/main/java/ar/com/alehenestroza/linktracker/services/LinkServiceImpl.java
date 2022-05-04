package ar.com.alehenestroza.linktracker.services;

import ar.com.alehenestroza.linktracker.dtos.LinkCreateRequestDTO;
import ar.com.alehenestroza.linktracker.dtos.LinkCreateResponseDTO;
import ar.com.alehenestroza.linktracker.dtos.LinkRedirectsResponseDTO;
import ar.com.alehenestroza.linktracker.exceptions.InvalidLinkPasswordException;
import ar.com.alehenestroza.linktracker.exceptions.LinkNotFoundException;
import ar.com.alehenestroza.linktracker.models.Link;
import ar.com.alehenestroza.linktracker.repositories.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;

    private Link findLink(Integer linkId) {
        Link link = linkRepository.get(linkId);
        if (link == null) {
            throw new LinkNotFoundException("No existe un link con ese ID.");
        }
        return link;
    }

    @Override
    public LinkCreateResponseDTO save(LinkCreateRequestDTO link) {
        Link newLink = new Link(link.getUrl(), link.getPassword());
        return new LinkCreateResponseDTO(linkRepository.save(newLink));
    }

    @Override
    public String getUrl(Integer linkId, String password) {
        Link link = findLink(linkId);
        if (!link.getPassword().equals(password)) {
            throw new InvalidLinkPasswordException("La contraseña es inválida.");
        }
        return link.getUrl().toString();
    }

    @Override
    public LinkRedirectsResponseDTO getMetrics(Integer linkId) {
        Link link = findLink(linkId);
        return new LinkRedirectsResponseDTO(link.getLinkId(), link.getRedirects());
    }

    @Override
    public Integer invalidate(Integer linkId) {
        findLink(linkId);
        return linkRepository.delete(linkId);
    }
}
