package com.example.linkpractice.service;

import com.example.linkpractice.DTO.request.CreateLinkDTO;
import com.example.linkpractice.DTO.response.CreateLinkDTOResponse;
import com.example.linkpractice.exceptions.NotFoundException;
import com.example.linkpractice.models.Link;
import com.example.linkpractice.repository.IRepository;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;

@Service
public class LinkService implements IService{
    IRepository repo;

    public LinkService(IRepository repo) {
        this.repo = repo;
    }

    @Override
    public String toString() {
        return "LinkService{" +
                "repo=" + repo +
                '}';
    }

    @Override
    public CreateLinkDTOResponse createLink(CreateLinkDTO link) {
       String newLink = "http://localhost:8080/".concat(link.getLink());
       // creo el model necesario para guardar en repository
       Link linkModel = new Link(newLink, 0, true, link.getPassword());
       // guardo el nuevo link en repository
       Integer linkID;
       try {
           linkID = repo.saveLink(linkModel);
       } catch (RuntimeException e){
           throw new RuntimeException(e.getMessage());
       }
       // devuelvo solamente el id del link guardado
       return new CreateLinkDTOResponse(linkID);
    }

    @Override
    public Integer getVisits() {
        return null;
    }

    @Override
    public void invalidate() {

    }

    @Override
    public String getLinkById(Integer id) {
        String linkById = repo.getLink(id);
        if (linkById == null) throw new NotFoundException("No se pudo encontrar el link con el ID " + id);
        return linkById;
    }

}
