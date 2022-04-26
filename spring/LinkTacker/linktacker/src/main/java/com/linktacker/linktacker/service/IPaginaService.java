package com.linktacker.linktacker.service;

import com.linktacker.linktacker.dto.PaginaRequestDTO;
import com.linktacker.linktacker.dto.PaginaResponseDTO;
import java.net.URL;
import java.util.HashMap;

public interface IPaginaService {
    PaginaResponseDTO crearPagina(PaginaRequestDTO paginaRequest);
    Integer visitasPaginas(Integer linkId);
    URL redirectURL(Integer linkId, String password);
    boolean deshabilitarPagina(Integer linkId);
    boolean habilitarPagina(Integer linkId);
}
