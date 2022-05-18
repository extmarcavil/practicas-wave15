package com.ejercicio.joyeria.service;

import com.ejercicio.joyeria.dto.JoyaDTO;
import com.ejercicio.joyeria.model.Joya;
import com.ejercicio.joyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Service
public class JoyaService implements IJoyaService {

    private final IJoyaRepository joyaRepo;
    private final ModelMapper modelMapper;

    public JoyaService(IJoyaRepository joyaRepo) {
        this.joyaRepo = joyaRepo;
        this.modelMapper= new ModelMapper();
    }

    @Override
    public Long saveJoya(JoyaDTO joyaDTO) {
        Joya joyaSave = modelMapper.map(joyaDTO, Joya.class);
        joyaSave = joyaRepo.save(joyaSave);
        return joyaSave.getNro_id();
    }

    @Override
    public List<JoyaDTO> getJoyas() {
            List<Joya> jewelList = joyaRepo.findAllByAvailable();
            List<JoyaDTO> jewlDTOList =jewelList
                    .stream()
                    .map(jewel -> modelMapper.map(jewel, JoyaDTO.class))
                    .collect(Collectors.toList());
            return jewlDTOList;
    }

    @Override
    public JoyaDTO findJoya(Long id) {
        Joya joya = joyaRepo.findById(id).orElseThrow(RuntimeException::new);
        return modelMapper.map(joya, JoyaDTO.class);
    }

    @Override
    public void deleteJoya(long id) {
        Joya jewel = joyaRepo.findById(id).orElseThrow(RuntimeException::new);
        jewel.setVentaONo(false);
        joyaRepo.save(jewel);
    }

    @Override
    public JoyaDTO editJoya(long id_modify, JoyaDTO jewelDTO) {
        Joya joyaEdit = modelMapper.map(jewelDTO, Joya.class);
        joyaEdit.setNro_id(id_modify);
        JoyaDTO joyaaDTO = modelMapper.map(joyaRepo.save(joyaEdit), JoyaDTO.class);
        return joyaaDTO;
    }

}
