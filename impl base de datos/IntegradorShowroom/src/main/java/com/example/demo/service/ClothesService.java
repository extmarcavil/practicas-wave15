package com.example.demo.service;

import com.example.demo.dto.ClothesDTO;
import com.example.demo.model.Clothes;
import com.example.demo.repository.IClothesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClothesService implements IClothesService{

    IClothesRepository clothesRepository;
    ModelMapper mapper;

    public ClothesService(IClothesRepository clothesRepository, ModelMapper modelMapper) {
        clothesRepository = clothesRepository;
        mapper = modelMapper;
    }

    public ClothesDTO saveClothes(ClothesDTO clothesDTO)
    {
        Clothes clothes1 = mapper.map(clothesDTO, Clothes.class);
        Clothes clothes = clothesRepository.save(clothes1);
        return mapper.map(clothes,ClothesDTO.class);
    }

}
