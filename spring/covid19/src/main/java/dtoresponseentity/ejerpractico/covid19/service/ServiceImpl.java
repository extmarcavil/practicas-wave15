package dtoresponseentity.ejerpractico.covid19.service;

import dtoresponseentity.ejerpractico.covid19.dto.PacienteDTO;
import dtoresponseentity.ejerpractico.covid19.dto.SintomaDTO;
import dtoresponseentity.ejerpractico.covid19.model.Sintoma;
import dtoresponseentity.ejerpractico.covid19.repository.IRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements IService {

    private final IRepository repository;

    @Override
    public SintomaDTO buscarPorNombre(String nombre) {
        Sintoma sintoma=repository.findByNombre(nombre);
        return SintomaDTO.builder()
                .nombre(sintoma.getNombre())
                .nivelDeGravedad(sintoma.getNivelDeGravedad())
                .build();
    }

    @Override
    public List<SintomaDTO> listarSintomas() {
        return repository.findAll().stream()
                .map(sintoma -> new SintomaDTO(sintoma.getNombre(),sintoma.getNivelDeGravedad()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PacienteDTO> listarPacientesRiesgo() {
        ModelMapper mapper = new ModelMapper();
        return repository.findGreaterThan(60)
                .stream()
                .map(persona -> mapper.map(persona,PacienteDTO.class))
                .collect(Collectors.toList());

        /*repository.findGreaterThan(60)
                .stream()
                .map(persona -> new PacienteDTO(
                        persona.getNombre(),
                        persona.getApellido() ,
                        persona.getSintomas()
                                .stream()
                                .map(sintoma -> new SintomaDTO(sintoma.getNombre(), sintoma.getNivelDeGravedad()))
                                .collect(Collectors.toList())
                        )
                )
                .collect(Collectors.toList());*/
    }
}
