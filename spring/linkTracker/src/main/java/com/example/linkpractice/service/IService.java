package com.example.linkpractice.service;


import com.example.linkpractice.DTO.request.CreateLinkDTO;
import com.example.linkpractice.DTO.response.CreateLinkDTOResponse;

public interface IService {

    CreateLinkDTOResponse createLink(CreateLinkDTO link);
    Integer getVisits();
    void invalidate();
    String getLinkById(Integer id);
}
