package com.vparula.links.servicios;

import com.vparula.links.dtos.LinkDTO;
import com.vparula.links.entidades.Link;
import com.vparula.links.excepciones.InvalidatedLinkException;
import com.vparula.links.excepciones.NotFoundException;
import com.vparula.links.excepciones.WrongCredentialsException;
import com.vparula.links.repositorio.IRepositoryLink;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ServiceLink implements IServiceLink {
    IRepositoryLink repo;
    ModelMapper mapper;

    public ServiceLink(IRepositoryLink repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
    }

    @Override
    public LinkDTO crearLink(String link, String password) {
        Link linkEnt = new Link(link,password);
        repo.agregar(linkEnt);
        LinkDTO dto = mapper.map(linkEnt, LinkDTO.class);
        return dto;
    }

    @Override
    public String getLinkUrl(Integer linkId, String pwd) {
        if (repo.hasLink(linkId)){
            Link link = repo.getLink(linkId);
            if(link.isValido() && compararPwd(link.getPwd(),pwd)) {
                link.visitar();
                return link.getLink();
            }else{
                throw new InvalidatedLinkException("El link al que desea acceder esta temporalmente desactivado: " + linkId);
            }
        }else{
            throw new NotFoundException("El link al que desea acceder no existe: " + linkId);
        }
    }

    @Override
    public Integer getRedirects(Integer linkId) {
        if (!repo.hasLink(linkId)){
            throw new NotFoundException("El link al que desea acceder no existe: " + linkId);
        }
            return repo.getLink(linkId).getVisitas();
        }

    @Override
    public LinkDTO invalidarLink(Integer linkId) {
        if (!repo.hasLink(linkId)){
            throw new NotFoundException("El link al que desea acceder no existe: " + linkId);
        }

        Link link = repo.getLink(linkId);
        link.setValido(false);
        LinkDTO dto = mapper.map(link, LinkDTO.class);
        return dto;
    }

    private boolean compararPwd(String s1, String s2){
        if(s1==null){
            return true;
        }else if (s2!=null && s1.equals(s2)){
            return true;
        }else{
            throw new WrongCredentialsException("Link protegido. No tiene acceso suficiente");
        }

    }
}
