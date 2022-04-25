package com.ejerciciodeportista.ejerciciodeportista.repository;

import com.ejerciciodeportista.ejerciciodeportista.dto.DeportistaDTO;
import java.util.List;

public interface DeportistaRepository {
    public List<DeportistaDTO> listarDeportistas();
}
