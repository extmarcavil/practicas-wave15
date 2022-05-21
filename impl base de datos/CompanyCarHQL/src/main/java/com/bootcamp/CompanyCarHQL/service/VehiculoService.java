package com.bootcamp.CompanyCarHQL.service;

import com.bootcamp.CompanyCarHQL.DTO.SiniestroDto;
import com.bootcamp.CompanyCarHQL.DTO.VehiculoDto;
import com.bootcamp.CompanyCarHQL.model.Vehiculo;
import com.bootcamp.CompanyCarHQL.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{

    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }


    @Override
    public VehiculoDto crearVehiculo(VehiculoDto vehiculoDto) {
        ModelMapper mapper = new ModelMapper();
        Vehiculo vehiculo = mapper.map(vehiculoDto, Vehiculo.class);
        vehiculoRepository.save(vehiculo);
        return vehiculoDto;
    }

    @Override
    public List<VehiculoDto> getAllVehiculos() {
        findAllPatentes();
        System.out.println(" findAllPatentes -------------------------");

        findPatenteAndMarcaSortByYear();
        System.out.println("findPatenteAndMarcaSortByYear -------------------------");

        findPatenteWhereWheelsGreaterThat(2022);
        System.out.println("findPatenteWhereWheelsGreaterThat -------------------------");



        ModelMapper mapper = new ModelMapper();
        List<VehiculoDto> vehiculoDtos = vehiculoRepository.findAll().stream().map((vehiculo -> mapper.map(vehiculo, VehiculoDto.class))).collect(Collectors.toList());
        return vehiculoDtos;
    }

    public void findAllPatentes(){
        System.out.println(vehiculoRepository.findAllPatente());
    }

    public void findPatenteAndMarcaSortByYear(){
        System.out.println(vehiculoRepository.findPatenteAndMarcaSortByYear());

    }

    public void findPatenteWhereWheelsGreaterThat(Integer year){
        System.out.println(vehiculoRepository.findPatenteWhereWheelsGreaterThat(year));
    }
    @Override
    public void crearSiniestro(SiniestroDto siniestroDto) {

    }

    @Override
    public List<SiniestroDto> getAllSiniestros() {
        return null;
    }
}
