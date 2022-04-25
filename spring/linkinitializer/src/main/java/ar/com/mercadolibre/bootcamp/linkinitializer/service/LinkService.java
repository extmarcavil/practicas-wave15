package ar.com.mercadolibre.bootcamp.linkinitializer.service;

import ar.com.mercadolibre.bootcamp.linkinitializer.dto.CreateLinkDTO;
import ar.com.mercadolibre.bootcamp.linkinitializer.dto.MetricsDTO;
import ar.com.mercadolibre.bootcamp.linkinitializer.dto.ResponseLinkDTO;

public interface LinkService {
    ResponseLinkDTO save(CreateLinkDTO dto);
    String getUrl(Long id, String password);
    MetricsDTO metrics(Long id);
    void invalidate(Long id);
}
