package com.example.linkpractice.service;


import com.example.linkpractice.DTO.request.CreateLinkDTO;
import com.example.linkpractice.DTO.response.CreateLinkDTOResponse;

public interface IService {

    public CreateLinkDTOResponse createLink(CreateLinkDTO link);
    public Integer getVisits();
    public void invalidate();
}
