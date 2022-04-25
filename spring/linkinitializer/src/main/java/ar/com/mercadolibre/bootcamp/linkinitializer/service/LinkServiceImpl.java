package ar.com.mercadolibre.bootcamp.linkinitializer.service;

import ar.com.mercadolibre.bootcamp.linkinitializer.dto.CreateLinkDTO;
import ar.com.mercadolibre.bootcamp.linkinitializer.dto.MetricsDTO;
import ar.com.mercadolibre.bootcamp.linkinitializer.dto.ResponseLinkDTO;
import ar.com.mercadolibre.bootcamp.linkinitializer.exceptions.*;
import ar.com.mercadolibre.bootcamp.linkinitializer.model.Link;
import ar.com.mercadolibre.bootcamp.linkinitializer.repository.LinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;
    private final ModelMapper mapper;

    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public ResponseLinkDTO save(CreateLinkDTO dto) {
        if (!startsWithdWWW(dto.getLink()) || !endsWithdDotCom(dto.getLink())) {
            throw new CustomMalformedUrlException(dto.getLink());
        }
        return linkRepository.save(dto.getLink(), dto.getPassword())
                .map(lm -> mapper.map(lm, ResponseLinkDTO.class))
                .orElseGet(() -> { throw new UrlExistentException(); });
    }

    @Override
    public String getUrl(Long id, String password) {
        Optional<Link> ol = linkRepository
                .findById(id);

        if (ol.isEmpty()) {
            throw  new UrlNonExistentException();
        } else {
            Link model = ol.get();
            if (model.getInvalidated()) {
                throw new InvalidatedUrlExceptionI();
            }
            if (!model.getPassword().equals(password)) {
                throw new WrongPasswordException();
            }
            model.addRedirect();
            return model.getUrl();
        }
    }

    @Override
    public MetricsDTO metrics(Long id) {
        return linkRepository
                .findById(id)
                .map(model -> mapper.map(model, MetricsDTO.class))
                .orElseGet(() -> { throw new UrlNonExistentException(); });
    }

    @Override
    public void invalidate(Long id) {
        Optional<Link> ol = linkRepository
                .findById(id);

        if (ol.isEmpty()) {
            throw  new UrlNonExistentException();
        } else {
            Link model = ol.get();
            model.invalidate();
        }
    }

    private boolean endsWithdDotCom(String url) {
        return url.endsWith(".com") ||
                url.endsWith(".com.ar") ||
                url.endsWith(".com.uy") ||
                url.endsWith(".com.br") ||
                url.endsWith(".com.co") ||
                url.endsWith(".com.mx");
    }

    private boolean startsWithdWWW(String url) {
        return url.startsWith("www.");
    }
}
