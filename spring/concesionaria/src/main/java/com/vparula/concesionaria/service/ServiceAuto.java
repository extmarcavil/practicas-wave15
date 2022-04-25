package com.vparula.concesionaria.service;

import com.vparula.concesionaria.dto.AutoDTO;
import com.vparula.concesionaria.model.Auto;
import com.vparula.concesionaria.repo.IRepoAuto;
import com.vparula.concesionaria.repo.RepoAuto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceAuto implements IServiceAuto{
    IRepoAuto repo;
    private ModelMapper mapper;

    public ServiceAuto ( IRepoAuto repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
    }

    @Override
    public void agregarAuto(Auto auto) {
        repo.agregarAuto(auto);

    }

    @Override
    public List<AutoDTO> getAutos() {
        List<Auto> autos = repo.getAutos();
       return mapeo(autos);
    }

    @Override
    public List<AutoDTO> getAutosFecha(Date since, Date to) {
        List<Auto> autos = repo.getAutosFiltradosF(since, to);


        return mapeo(autos);
    }

    @Override
    public List<AutoDTO> getAutosPrecio(Double since, Double to) {
        List<Auto> autos = repo.getAutosFiltradosP(since, to);


        return mapeo(autos);
    }


    private List<AutoDTO> mapeo(List<Auto> autos){
        List<AutoDTO> autosDTO = new ArrayList<>();
        if(autos !=null && autos.size()>0) {
            autosDTO = autos.stream().map(ing -> mapper.map(ing, AutoDTO.class)).collect(Collectors.toList());
        }
        return autosDTO;
    }
}
