package com.example.segurosautos.service;

import com.example.segurosautos.dto.VehiculoPatenteDTO;
import com.example.segurosautos.dto.VehiculoPatenteYMarcaDTO;
import com.example.segurosautos.dto.VehiculoPatenteYMarcaYModeloDTO;
import com.example.segurosautos.dto.VehiculoSiniestroDTO;
import com.example.segurosautos.model.Siniestro;
import com.example.segurosautos.model.Vehiculo;
import com.example.segurosautos.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{

    private final VehiculoRepository vehiculoRepository;
    private final ISiniestroService siniestroService;

    public VehiculoService(VehiculoRepository vehiculoRepository, ISiniestroService siniestroService) {
        this.vehiculoRepository = vehiculoRepository;
        this.siniestroService = siniestroService;
    }

    @Override
    public List<VehiculoPatenteDTO> findAllPatente() {
        ModelMapper mapper = new ModelMapper();
        return vehiculoRepository.findAllPatente()
                .stream()
                .map(v -> mapper.map(v, VehiculoPatenteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteYMarcaDTO> findAllVehiculoPatenteAndMarca() {
        ModelMapper mapper = new ModelMapper();
        return vehiculoRepository.findAllVehiculoPatenteAndMarca()
                .stream()
                .map(v->mapper.map(v, VehiculoPatenteYMarcaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteDTO> findVehiculoPatenteByCantRuedasAndCurrentYear() {
        ModelMapper mapper = new ModelMapper();
        return vehiculoRepository.findVehiculoPatenteByCantRuedasAndCurrentYear(LocalDate.now().getYear())
                .stream()
                .map(v -> mapper.map(v, VehiculoPatenteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteYMarcaYModeloDTO> findByCostGreaterThan(Double cost) {
        List<Siniestro> siniestro = siniestroService.findByCostGreaterThan(cost);
        Set<VehiculoPatenteYMarcaYModeloDTO> result = new HashSet<>();
        siniestro.forEach(s -> {
            VehiculoPatenteYMarcaYModeloDTO vehiculoPatenteYMarcaYModeloDTO = new VehiculoPatenteYMarcaYModeloDTO();
            vehiculoPatenteYMarcaYModeloDTO.setPatente(s.getVehiculo().getPatente());
            vehiculoPatenteYMarcaYModeloDTO.setMarca(s.getVehiculo().getMarca());
            vehiculoPatenteYMarcaYModeloDTO.setModelo(s.getVehiculo().getModelo());
            result.add(vehiculoPatenteYMarcaYModeloDTO);
        });
        return List.copyOf(result);
    }

    @Override
    public VehiculoSiniestroDTO findBySiniestroCostGreaterThanAndTotalCost(Double cost) {
        ModelMapper mapper = new ModelMapper();
        VehiculoSiniestroDTO vehiculoSiniestroDTO = new VehiculoSiniestroDTO();
        vehiculoSiniestroDTO.setCostoTotal(siniestroService.findBySiniestroCostGreaterThanAndTotalCost(10000D));
        Set<VehiculoPatenteYMarcaYModeloDTO> vehiculoPatenteYMarcaYModeloDTOS = Set.copyOf(siniestroService.findByCostGreaterThan(10000D)
                                                                                    .stream()
                                                                                    .map(s->mapper.map(s.getVehiculo(), VehiculoPatenteYMarcaYModeloDTO.class))
                                                                                    .collect(Collectors.toList()));
        vehiculoSiniestroDTO.setVehiculoDTO(List.copyOf(vehiculoPatenteYMarcaYModeloDTOS));
        return vehiculoSiniestroDTO;
    }

    @Override
    public Vehiculo findById(Integer id) {
        return vehiculoRepository.findById(id).orElseThrow();
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
}
