package com.mercadolibre.bootcamp.deportista.service;

import com.mercadolibre.bootcamp.deportista.dto.DeporteDto;
import com.mercadolibre.bootcamp.deportista.entities.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("deporteService")
public class DeporteServiceImpl implements ICRUDService<DeporteDto, DeporteDto> {

    /**
     * Atributos
     */
    private List<Deporte> listDeporte = new ArrayList<>();
    private List<DeporteDto> listDporteDto = new ArrayList<>();

    /**
     * Metodos
     *
     * @param objDto
     * @return
     */
    @Override
    public DeporteDto save(DeporteDto objDto) {
        Deporte sport = new Deporte();
        sport.setName(objDto.getSportName());
        sport.setLevel(objDto.getLevel());

        listDeporte.add(sport);
        listDporteDto.add(objDto);

        return objDto;
    }

    @Override
    public List<DeporteDto> findAll() {
        return listDporteDto;
    }

    @Override
    public DeporteDto findByName(String name) {
        DeporteDto sport = listDporteDto.stream().filter(d -> d.getSportName().equals(name)).findFirst().get();
        return sport;
    }


    /**
     * Getter
     */
    public List<DeporteDto> getListDporteDto() {
        return listDporteDto;
    }
}

