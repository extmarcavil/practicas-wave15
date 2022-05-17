package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaRequestDTO;
import com.example.joyeria.dto.JoyaRequestUpdateDTO;
import com.example.joyeria.dto.JoyaResponseDTO;
import com.example.joyeria.exceptions.JoyaNotFoundException;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository joyaRepository;
    private final ModelMapper modelMapper;

    public JoyaService(IJoyaRepository joyaRepository){
        this.joyaRepository = joyaRepository;
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
    }

    @Override
    public Long save(JoyaRequestDTO joyaDTO) {
        joyaDTO.setVentaONo(true);
        return joyaRepository.save(modelMapper.map(joyaDTO, Joya.class)).getNro_identificatorio();
    }

    @Override
    public void deleteById(Long id) {
        JoyaResponseDTO joyaToDelete = findById(id);
        joyaToDelete.setVentaONo(false);
        joyaRepository.save(modelMapper.map(joyaToDelete, Joya.class));
    }

    @Override
    public List<JoyaResponseDTO> findAll() {
        List<Joya> response = joyaRepository.findAll();
        return response
                .stream()
                .filter(Joya::getVentaONo)
                .map(joya -> modelMapper.map(joya, JoyaResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public JoyaResponseDTO findById(Long id) {
        Joya joya = joyaRepository.findById(id).orElseThrow(() -> new JoyaNotFoundException("No existe joya con id: " + id));
        if(!joya.getVentaONo()){
            throw new JoyaNotFoundException("No existe joya con id: " + id);
        }
        return modelMapper.map(joya, JoyaResponseDTO.class);
    }

    @Override
    public JoyaResponseDTO updateById(Long joyaId, JoyaRequestUpdateDTO joyaDTO) {
        JoyaResponseDTO joyaAux = findById(joyaId);
        Joya joyaToUpdate = modelMapper.map(joyaAux, Joya.class);
        modelMapper.map(joyaDTO, joyaToUpdate);
        return modelMapper.map(joyaRepository.save(joyaToUpdate), JoyaResponseDTO.class);
    }
}
