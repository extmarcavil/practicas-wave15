package com.bootcamp.jewelry.service;

import com.bootcamp.jewelry.dto.ReqJewelDTO;
import com.bootcamp.jewelry.dto.ResJewlDTO;
import com.bootcamp.jewelry.model.Jewel;
import com.bootcamp.jewelry.repository.JewelryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelryService implements IJewelryService {

    private final JewelryRepository jewelryRepository;

    private ModelMapper modelMapper;

    public JewelryService(JewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
        this.modelMapper= new ModelMapper();
    }

    @Override
    @Transactional( readOnly = true)
    public List<ResJewlDTO> getJewels() {
        List<Jewel> jewelList = jewelryRepository.findAllByAvailableTrue();
        List<ResJewlDTO> jewlDTOList =jewelList
                .stream()
                .map(jewel -> modelMapper.map(jewel, ResJewlDTO.class))
                .collect(Collectors.toList());
        return jewlDTOList;
    }

    @Override
    @Transactional
    public Long saveJewel(ReqJewelDTO jewelDTO) {
        Jewel jewel = modelMapper.map(jewelDTO, Jewel.class);
        jewel = jewelryRepository.save(jewel);
        return jewel.getIdentification_num();
    }

    @Override
    @Transactional
    public void deleteJewel(long id) {
        Jewel jewel = jewelryRepository.findById(id).orElseThrow(()-> new RuntimeException());
        jewel.setAvailable(false);
        jewelryRepository.save(jewel);
    }

    @Override
    @Transactional
    public ResJewlDTO updateJewel(long id_modify, ReqJewelDTO jewelDTO) {
        Jewel jewel = modelMapper.map(jewelDTO, Jewel.class);
        jewel.setIdentification_num(id_modify);
        ResJewlDTO resJewelDTO= modelMapper.map(jewelryRepository.save(jewel), ResJewlDTO.class);
        return resJewelDTO;
    }

    @Override
    @Transactional( readOnly = true)
    public ResJewlDTO findJewel(long id) {
        Jewel jewel = jewelryRepository.findById(id).orElseThrow(()-> new RuntimeException());
        ResJewlDTO resJewlDTO = modelMapper.map(jewel, ResJewlDTO.class);
        return resJewlDTO;
    }
}
