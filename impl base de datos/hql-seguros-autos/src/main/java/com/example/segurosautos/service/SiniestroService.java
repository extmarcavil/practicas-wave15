package com.example.segurosautos.service;

import com.example.segurosautos.dto.SiniestroDTO;
import com.example.segurosautos.model.Siniestro;
import com.example.segurosautos.model.Vehiculo;
import com.example.segurosautos.repository.SiniestroRepository;
import com.example.segurosautos.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class SiniestroService implements ISiniestroService{
    private final SiniestroRepository siniestroRepository;
    //private final IVehiculoService vehiculoService;
    private final VehiculoRepository vehiculoRepository;
    public SiniestroService(SiniestroRepository siniestroRepository, VehiculoRepository vehiculoRepository) {
        this.siniestroRepository = siniestroRepository;
        //this.vehiculoService = vehiculoService;
        this.vehiculoRepository = vehiculoRepository;
    }


    @Override
    public SiniestroDTO save(SiniestroDTO siniestroDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Siniestro siniestroToSave = modelMapper.map(siniestroDTO, Siniestro.class);
        if(siniestroToSave.getVehiculo().getId()==null){
            //vehiculoService.save(siniestroToSave.getVehiculo());
            vehiculoRepository.save(siniestroToSave.getVehiculo());
        }
        return modelMapper.map(siniestroRepository.save(siniestroToSave), SiniestroDTO.class);
    }

    @Override
    public List<Siniestro> findByCostGreaterThan(Double cost) {
        return siniestroRepository.findByCostGreaterThan(10000D);
    }

    @Override
    public Double findBySiniestroCostGreaterThanAndTotalCost(Double cost) {
        return siniestroRepository.findBySiniestroCostGreaterThanAndTotalCost(10000D);
    }
}
