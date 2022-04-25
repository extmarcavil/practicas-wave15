package com.example.linkpractice.service;

import com.example.linkpractice.dtos.LinkResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements IService{

    @Override
    public LinkResponseDTO createLink() {

    }

    @Override
    public Integer getVisits() {
        return null;
    }

    @Override
    public void invalidate() {

    }

}
