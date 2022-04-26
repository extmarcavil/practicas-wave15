package com.example.linktracker.service;

import com.example.linktracker.dto.request.UrlLinkDTO;
import com.example.linktracker.dto.response.IdLinkDTO;
import com.example.linktracker.exceptions.InvalidUrlException;
import com.example.linktracker.model.Link;
import com.example.linktracker.repository.ILinkTrackerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LinkTrackerService implements ILinkTrackerService {

    private final ILinkTrackerRepository repository;
    private ModelMapper mapper = new ModelMapper();

    public LinkTrackerService(ILinkTrackerRepository repository) {
        this.repository = repository;
    }

    @Override
    public IdLinkDTO createLink(UrlLinkDTO urlDTO) {
        if (!Link.validateUrl(urlDTO.getUrl())){
            throw new InvalidUrlException("Url inválida");
        }
        int id = repository.createLink(urlDTO.getUrl());
        return new IdLinkDTO(id);
    }
}
