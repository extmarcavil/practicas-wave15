package ar.com.alehenestroza.linktracker.services;

import ar.com.alehenestroza.linktracker.dtos.LinkCreateRequestDTO;
import ar.com.alehenestroza.linktracker.dtos.LinkCreateResponseDTO;
import ar.com.alehenestroza.linktracker.dtos.LinkRedirectsResponseDTO;

public interface LinkService {
    LinkCreateResponseDTO save(LinkCreateRequestDTO link);

    String getUrl(Integer linkId, String password);

    LinkRedirectsResponseDTO getMetrics(Integer linkId);

    Integer invalidate(Integer linkId);
}
