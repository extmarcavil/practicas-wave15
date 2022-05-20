package com.apiempleados.service;

import com.apiempleados.domain.Empleado;
import com.apiempleados.dto.EmpleadoDTO;
import com.apiempleados.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService  implements  IEmpleadoService{
    private IEmpleadoRepository empleadoRepository;
    private ModelMapper mapper;

    public EmpleadoService(IEmpleadoRepository empleadoRepository,ModelMapper mapper) {
        this.empleadoRepository = empleadoRepository;
        this.mapper = mapper;
    }

    @Override
    public EmpleadoDTO crear(EmpleadoDTO empleado) {
        Empleado nuevoEmpleado = empleadoRepository.save(mapper.map(empleado,Empleado.class));
        return mapper.map(nuevoEmpleado,EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO actualizar(String id, EmpleadoDTO empleado) {
        Empleado empleadoDomain = empleadoRepository.findById(id)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("El empleado no existe" + id));
        empleadoDomain = mapper.map(empleado,Empleado.class);
        empleadoDomain.setId(id);
        empleadoRepository.save(empleadoDomain);
        return mapper.map(empleadoDomain,EmpleadoDTO.class);
    }

    @Override
    public List<EmpleadoDTO> todosEmpleados() {
        List<EmpleadoDTO> listResult = new ArrayList<>();
        Iterable<Empleado> listEmpleadosDomain = empleadoRepository.findAll();
        listEmpleadosDomain.forEach(emp -> listResult.add(mapper.map(emp,EmpleadoDTO.class)));
        return listResult;
    }
}
