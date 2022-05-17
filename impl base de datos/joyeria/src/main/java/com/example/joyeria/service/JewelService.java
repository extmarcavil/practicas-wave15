package com.example.joyeria.service;

import com.example.joyeria.api.dto.JewelDto;
import com.example.joyeria.api.dto.NroIdentificatorioDto;
import com.example.joyeria.api.mapper.JewelMapper;
import com.example.joyeria.api.mapper.NroIdentificatorioMapper;
import com.example.joyeria.entity.Jewel;
import com.example.joyeria.repository.JewelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        jewel.setEnVenta(true);
        NroIdentificatorioDto nroId=mapperNro.jewelToNroIdentidicatorioDto( jewelRepository.save(jewel));
        return nroId;
    }

    public List<JewelDto> findAll(){
        return jewelRepository.findAllByEnVentaIsTrue()
                .stream()
                .map(jewel -> mapper.jewelToJewelDto(jewel))
                .collect(Collectors.toList());
    }

    @Transactional()
    public NroIdentificatorioDto delete(Long id){
        Jewel jewel = jewelRepository.findByIdJewelAndEnVentaIsTrue(id).orElseThrow(() -> new RuntimeException("hola"));
        jewel.setEnVenta(false);
        return mapperNro.jewelToNroIdentidicatorioDto(
                jewelRepository.save(jewel)
        );
    }

    public JewelDto update(Long id, JewelDto jewelDto){
        Jewel jewel = jewelRepository.findById(id).orElseThrow(()->new RuntimeException("hola"));
        mapper.updateJewelFromJewelDto(jewelDto,jewel);
        return mapper.jewelToJewelDto(jewelRepository.save(jewel));

    }

}
