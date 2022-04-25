package com.vparula.concesionaria.repo;

import com.vparula.concesionaria.model.Auto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepoAuto implements IRepoAuto{
    List<Auto> autos = new ArrayList<>();

    @Override
    public void agregarAuto(Auto auto) {
        autos.add(auto);

    }

    public List<Auto> getAutos(){
        return autos;
    }

    @Override
    public List<Auto> getAutosFiltradosF(Date since, Date to) {
        List<Auto>autosFiltrados=
                autos.stream()
                        .filter(s->s.getManufacturingDate().after(since)&&s.getManufacturingDate().before(to))
                        .collect(Collectors.toList());
        return autosFiltrados;

    }

    @Override
    public List<Auto> getAutosFiltradosP(Double since, Double to) {
        List<Auto>autosFiltrados=
                autos.stream()
                        .filter(s->s.getPrice()>=since&&s.getPrice()<=to)
                        .collect(Collectors.toList());
        return autosFiltrados;
    }
}
