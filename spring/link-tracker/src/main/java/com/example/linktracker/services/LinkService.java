package com.example.linktracker.services;

import com.example.linktracker.dto.LinkResponseDTO;

import java.net.URL;

public interface LinkService {
    Integer save(String url, String password);
    URL redirect(Integer id, String password);
    LinkResponseDTO getStatistics(Integer id);
    void invalidate(Integer id);
}
