package com.ejerciciodeportista.ejerciciodeportista.service;

import com.ejerciciodeportista.ejerciciodeportista.dto.DeporteDTO;
import java.util.List;

public interface DeporteServicio {
    public List<DeporteDTO> listarDeportes();
    public String buscarDeporte(String nombre);
}
