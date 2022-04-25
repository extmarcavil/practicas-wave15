package com.example.linkpractice.service;


import com.example.linkpractice.dtos.LinkResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IService {

    public LinkResponseDTO createLink();
    public Integer getVisits();
    public void invalidate();
}
