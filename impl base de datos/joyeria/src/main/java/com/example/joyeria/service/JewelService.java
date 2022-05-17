package com.example.joyeria.service;

import com.example.joyeria.api.dto.JewelDto;
import com.example.joyeria.api.dto.NroIdentificatorioDto;
import com.example.joyeria.api.mapper.JewelMapper;
import com.example.joyeria.api.mapper.NroIdentificatorioMapper;
import com.example.joyeria.entity.Jewel;
import com.example.joyeria.repository.JewelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JewelService {

    private final JewelRepository jewelRepository;
    private final JewelMapper mapper;

    private final NroIdentificatorioMapper mapperNro;

    public NroIdentificatorioDto create(JewelDto jewelDto){
        Jewel jewel =mapper.jewelDtoToJewel(jewelDto);
        NroIdentificatorioDto nroId=mapperNro.jewelToNroIdentidicatorioDto( jewelRepository.save(jewel));
        return nroId;
    }

    public List<JewelDto> findAll(){
        return jewelRepository.findAll()
                .stream()
                .map(jewel -> mapper.jewelToJewelDto(jewel))
                .collect(Collectors.toList());
    }

}
