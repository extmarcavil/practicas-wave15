package com.mercadolibre.bootcamp_api_deportistas.service;

import com.mercadolibre.bootcamp_api_deportistas.entity.Sport;
import com.mercadolibre.bootcamp_api_deportistas.repository.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportServiceImpl implements SportService {
    private final SportRepository sportRepository;

    @Override
    public List<Sport> findSports() {
        return sportRepository.getSports();
    }

    @Override
    public Sport findSport(String name) {
        return sportRepository.getSport(name);
    }
}
