package com.example.linkpractice.service;

import com.example.linkpractice.dtos.LinkResponseDTO;
import com.example.linkpractice.models.Link;
import com.example.linkpractice.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements IService {

    IRepository repo;

    public LinkService(IRepository repo) {
        this.repo = repo;
    }

    @Override
    public LinkResponseDTO createLink(String linkInfo, String password) {
        return new LinkResponseDTO(repo.saveLink(new Link(linkInfo, password)));
    }

    @Override
    public String redirect(Integer id) {
        Link link = repo.getLink(id);
        link.sumVisit();
        return link.getLink();
    }

    @Override
    public Integer getVisits(Integer id) {
        return repo.getLink(id).getVisits();
    }

    @Override
    public void invalidate(Integer id) {
        repo.getLink(id).setValid(false);
    }

}
