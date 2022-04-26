package com.example.linktracker.service;

import com.example.linktracker.DTO.LinkDTO;

import java.util.List;

public interface ILinkService {

    Boolean checkLink(String link);
    public Boolean linkExists(String link);
    Integer saveLink(LinkDTO dto);
    List<LinkDTO> mostrarLinks();
    String getUrlFromId(Integer id);

}
