package com.example.demo.services;

import com.example.demo.domain.Empleado;
import com.example.demo.elasticrepositories.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    private final EmpleadoRepository articuloRepository;

    public EmpleadoServiceImpl(EmpleadoRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public Empleado save(Empleado empleado) {
        return articuloRepository.save(empleado
        );
    }
}
