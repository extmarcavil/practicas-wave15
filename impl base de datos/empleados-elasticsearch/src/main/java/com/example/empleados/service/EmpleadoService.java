package com.example.empleados.service;

import com.example.empleados.domain.Empleado;
import com.example.empleados.dto.EmpleadoDTO;
import com.example.empleados.dto.EmpleadoRequestDTO;
import com.example.empleados.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService implements IEmpleadoService{
    private IEmpleadoRepository empleadoRepository;
    private ModelMapper modelMapper;

    public EmpleadoService(IEmpleadoRepository empleadoRepository, ModelMapper modelMapper) {
        this.empleadoRepository = empleadoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmpleadoDTO save(EmpleadoRequestDTO empleado) {
        Empleado empleadoToSave = modelMapper.map(empleado, Empleado.class);
        return modelMapper.map(empleadoRepository.save(empleadoToSave), EmpleadoDTO.class);
    }


    @Override
    public List<EmpleadoDTO> findAll() {
        List<EmpleadoDTO> empleados = new ArrayList<>();
        empleadoRepository.findAll().forEach(e -> {
            empleados.add(modelMapper.map(e, EmpleadoDTO.class));
        });
        return empleados;
    }

    @Override
    public EmpleadoDTO findByEdad(Integer edad) {
        return modelMapper.map(empleadoRepository.findEmpleadoByEdad(edad).orElse(null), EmpleadoDTO.class);
    }

    @Override
    public List<EmpleadoDTO> findAllByEdad(Integer edad) {
        return empleadoRepository.findAllByEdad(edad)
                .stream()
                .map(e -> modelMapper.map(e, EmpleadoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmpleadoDTO> findAllByNombreLike(String nombre) {
        return empleadoRepository.findAllByNombreLike(nombre)
                .stream()
                .map(e -> modelMapper.map(e, EmpleadoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteAll() {
        try {
             empleadoRepository.deleteAll();
            return "Empleados eliminados";
        }
        catch (RuntimeException e){
            return "Error: empleados no eliminados";
        }
    }
}
