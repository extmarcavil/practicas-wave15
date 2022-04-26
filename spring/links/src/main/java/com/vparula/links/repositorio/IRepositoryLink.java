package com.vparula.links.repositorio;


import com.vparula.links.entidades.Link;

public interface IRepositoryLink {

    public int agregar(Link link);
    public Link getLink (Integer id);
    public boolean hasLink(Integer id);
}
