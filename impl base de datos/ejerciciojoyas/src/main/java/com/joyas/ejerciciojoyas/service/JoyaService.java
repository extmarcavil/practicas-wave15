package com.joyas.ejerciciojoyas.service;

import com.joyas.ejerciciojoyas.dto.request.JoyaRequestDTO;
import com.joyas.ejerciciojoyas.dto.response.JoyaResponseDTO;
import com.joyas.ejerciciojoyas.model.Joya;
import com.joyas.ejerciciojoyas.repository.JoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{
    ModelMapper mapper = new ModelMapper();
    private final JoyaRepository joyaRepository;
    public JoyaService(JoyaRepository joyaRepository){
        this.joyaRepository=joyaRepository;
    }
    @Override
    public List<JoyaResponseDTO> getJoyas() {
        return this.joyaRepository.findAll()
                .stream()
                .filter(Joya::getVentaONo)
                .map(m-> mapper.map(m,JoyaResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public JoyaResponseDTO saveJoya(JoyaRequestDTO joya) {
        Joya joya1= mapper.map(joya,Joya.class);
        this.joyaRepository.save(joya1);
        return mapper.map(joya1, JoyaResponseDTO.class);
    }

    @Override
    public void deleteJoya(Long id) {
        Joya joya= this.findJoya(id);
        joya.setVentaONo(false);
        this.joyaRepository.save(joya);
        //this.joyaRepository.deleteById(id);
    }

    @Override
    public Joya findJoya(Long id) {
        return this.joyaRepository.findById(id).orElseGet(null);
    }

    @Override
    public void updateJoya(Long id_modificar, JoyaRequestDTO joyaConDatos) {
        Joya joyaAModificar = this.findJoya(id_modificar);
        joyaAModificar.setNombre(joyaConDatos.getNombre());
        joyaAModificar.setMaterial(joyaConDatos.getMaterial());
        joyaAModificar.setPeso(joyaConDatos.getPeso());
        joyaAModificar.setParticularidad(joyaConDatos.getParticularidad());
        joyaAModificar.setPosee_piedras(joyaConDatos.getPosee_piedras());
        joyaAModificar.setVentaONo(joyaConDatos.getVentaono());
        this.joyaRepository.save(joyaAModificar);
    }
}
