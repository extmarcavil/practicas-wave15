package com.vparula.links.servicios;

import com.vparula.links.dtos.LinkDTO;

public interface IServiceLink {

    public LinkDTO crearLink(String link, String password);
    public String getLinkUrl(Integer linkId,String pwd);
    public Integer getRedirects(Integer linkId);
    public LinkDTO invalidarLink(Integer linkId);
}
