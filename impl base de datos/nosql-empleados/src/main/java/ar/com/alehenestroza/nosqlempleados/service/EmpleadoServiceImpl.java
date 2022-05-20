package ar.com.alehenestroza.nosqlempleados.service;

import ar.com.alehenestroza.nosqlempleados.dto.request.NewEmpleadoDTO;
import ar.com.alehenestroza.nosqlempleados.dto.response.EmpleadoDTO;
import ar.com.alehenestroza.nosqlempleados.dto.response.EmpleadosDTO;
import ar.com.alehenestroza.nosqlempleados.entities.Empleado;
import ar.com.alehenestroza.nosqlempleados.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final ModelMapper mapper;

    @Override
    public EmpleadosDTO getAll() {
        EmpleadosDTO empleadosDTO = new EmpleadosDTO();
        for (Empleado e : empleadoRepository.findAll()) {
            EmpleadoDTO eDTO = mapper.map(e, EmpleadoDTO.class);
            empleadosDTO.getEmpleados().add(eDTO);
        }
        return empleadosDTO;
    }

    @Override
    public EmpleadoDTO save(NewEmpleadoDTO newEmpleadoDTO) {
        Empleado newEmpleado = mapper.map(newEmpleadoDTO, Empleado.class);
        return mapper.map(empleadoRepository.save(newEmpleado), EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO update(String id, NewEmpleadoDTO empleadoDTO) {
        Empleado emp = empleadoRepository.findById(id).orElse(null);
        if (emp == null) {
            throw new RuntimeException("Employee not found");
        }
        if (empleadoDTO.getName() != null) {
            emp.setName(empleadoDTO.getName());
        }
        if (empleadoDTO.getLastName() != null) {
            emp.setLastName(empleadoDTO.getLastName());
        }
        if (empleadoDTO.getState() != null) {
            emp.setState(empleadoDTO.getState());
        }
        if (empleadoDTO.getCity() != null) {
            emp.setCity(empleadoDTO.getCity());
        }
        if (empleadoDTO.getAge() != null) {
            emp.setAge(empleadoDTO.getAge());
        }
        return mapper.map(empleadoRepository.save(emp), EmpleadoDTO.class);
    }
}
