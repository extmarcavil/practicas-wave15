package com.linktacker.linktacker.service;

import com.linktacker.linktacker.dto.PaginaRequestDTO;
import com.linktacker.linktacker.dto.PaginaResponseDTO;
import com.linktacker.linktacker.entity.Pagina;
import com.linktacker.linktacker.exception.PaginaException;
import com.linktacker.linktacker.exception.PaginaInvalidaExeption;
import com.linktacker.linktacker.repository.IPaginaRepository;
import com.linktacker.linktacker.repository.PaginasRepository;
import org.springframework.stereotype.Service;
import java.net.URL;

@Service
public class PaginaService implements IPaginaService{
    private IPaginaRepository paginaRepository;

    public PaginaService(IPaginaRepository paginaRepository) {
        this.paginaRepository = paginaRepository;
    }

    @Override
    public PaginaResponseDTO crearPagina(PaginaRequestDTO paginaRequest) {
        Pagina entityPagina = new Pagina();
        entityPagina.setUrl(paginaRequest.getUrl());
        entityPagina.setPassword(paginaRequest.getPassword());
        entityPagina.setValidada(true);
        entityPagina.setCantidadVisitas(0);
        var paginaResultado = paginaRepository.crearPagina(entityPagina);
        PaginaResponseDTO paginaResponseDTO = new PaginaResponseDTO(paginaResultado.getId(), paginaResultado.getUrl());
        return paginaResponseDTO;
    }

    @Override
    public Integer visitasPaginas(Integer linkId) {
        return paginaRepository.visitasPaginas(linkId);
    }

    @Override
    public URL redirectURL(Integer linkId, String password) {
        var infoPagina = paginaRepository.paginaIdPassword(linkId, password);
        if(!infoPagina.isValidada())
            throw  new PaginaInvalidaExeption();

        paginaRepository.agregarVisita(linkId);

        return infoPagina.getUrl();
    }

    @Override
    public boolean deshabilitarPagina(Integer linkId) {
        paginaRepository.paginaInfo(linkId).setValidada(false);
        return true;
    }

    @Override
    public boolean habilitarPagina(Integer linkId) {
        paginaRepository.paginaInfo(linkId).setValidada(true);
        return true;
    }
}
