package com.vparula.concesionaria.service;

import com.vparula.concesionaria.dto.AutoDTO;
import com.vparula.concesionaria.model.Auto;

import java.util.Date;
import java.util.List;

public interface IServiceAuto {
    public void agregarAuto(Auto auto);
    public List<AutoDTO> getAutos();
    public List<AutoDTO> getAutosFecha(Date since, Date to);
    public List<AutoDTO> getAutosPrecio(Double since, Double to);
}
