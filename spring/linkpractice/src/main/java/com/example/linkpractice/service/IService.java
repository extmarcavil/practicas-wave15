package com.example.linkpractice.service;


import com.example.linkpractice.dtos.LinkResponseDTO;

public interface IService {
    LinkResponseDTO createLink(String link, String password);
    String redirect(Integer id);
    Integer getVisits(Integer id);
    void invalidate(Integer id);
}
