package com.meli.calculadoracalorias.services;

import com.meli.calculadoracalorias.dto.plateDTO;
import com.meli.calculadoracalorias.repositories.plateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class plateService {
    @Autowired
    plateRepository repository;

    public List<plateDTO> getPlate() {
        return repository.findAll();
    }
}
