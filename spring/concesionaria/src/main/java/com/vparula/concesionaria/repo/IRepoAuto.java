package com.vparula.concesionaria.repo;

import com.vparula.concesionaria.model.Auto;

import java.util.Date;
import java.util.List;

public interface IRepoAuto {
    public void agregarAuto(Auto auto);
    public List<Auto> getAutos();
    public List<Auto> getAutosFiltradosF(Date since, Date to);
    public List<Auto> getAutosFiltradosP(Double since, Double to);

}
