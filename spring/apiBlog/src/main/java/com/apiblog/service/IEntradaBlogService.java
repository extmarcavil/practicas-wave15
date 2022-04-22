package com.apiblog.service;

import com.apiblog.dto.request.EntradaBlogRequestDTO;
import com.apiblog.dto.response.EntradaBlogResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEntradaBlogService {
    Integer insertarEntradaBlog(EntradaBlogRequestDTO nuevaEntradaDTO);

    List<EntradaBlogResponseDTO> todoEntradaBlog();

    EntradaBlogResponseDTO entradaBlogId(int id);
}
