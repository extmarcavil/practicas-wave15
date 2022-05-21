package com.santiagopinzond.Joyeria.service;

import com.santiagopinzond.Joyeria.dto.JoyaDto;
import com.santiagopinzond.Joyeria.model.Joya;
import com.santiagopinzond.Joyeria.repository.IJoyaRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public Long createJoya(JoyaDto joyaDto) {
        ModelMapper mapper = new ModelMapper();
        Joya joya = mapper.map(joyaDto, Joya.class);
        return joyaRepository.save(joya).getNro_identificatorio();
    }

    @Override
    public List<JoyaDto> getAllJoyas() {
        ModelMapper mapper = new ModelMapper();
        List<JoyaDto> listJoyas = joyaRepository.findAll().stream().map((joya -> mapper.map(joya, JoyaDto.class))).collect(Collectors.toList());
        return  listJoyas;
    }

    @Override
    public void deleteJoya(Long id) {
        Optional<Joya> joya = joyaRepository.findById(id);
        joya.get().setVentaONo(false);
        joyaRepository.save(joya.get());
    }

    @Override
    public JoyaDto updateJoya(Long id, JoyaDto joyaDto) {
        ModelMapper mapper = new ModelMapper();
        Joya updateJoya = mapper.map(joyaDto, Joya.class);
        updateJoya.setNro_identificatorio(id);
        return mapper.map(joyaRepository.save(updateJoya), JoyaDto.class);
    }
}
