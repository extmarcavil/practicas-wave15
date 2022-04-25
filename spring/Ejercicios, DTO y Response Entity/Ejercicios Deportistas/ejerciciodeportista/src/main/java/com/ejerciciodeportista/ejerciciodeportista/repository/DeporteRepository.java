package com.ejerciciodeportista.ejerciciodeportista.repository;

import com.ejerciciodeportista.ejerciciodeportista.dto.DeporteDTO;
import java.util.List;

public interface DeporteRepository {
    public List<DeporteDTO> listarDeportes();
    public String buscarDeporte(String nombre);
}
