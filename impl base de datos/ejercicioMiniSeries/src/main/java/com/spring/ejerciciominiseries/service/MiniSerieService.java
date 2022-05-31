package com.spring.ejerciciominiseries.service;

import com.spring.ejerciciominiseries.repository.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {

    private final IMiniSerieRepository repository;


    public MiniSerieService(IMiniSerieRepository repository) {
        this.repository = repository;
    }
}
