package com.spring.ejerciciolasperlas.service;

import com.spring.ejerciciolasperlas.model.Jewerly;
import com.spring.ejerciciolasperlas.repository.IJewerlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JewerlyService implements IJewerlyService{
    private final IJewerlyRepository jewerlyRepository;

    public JewerlyService(IJewerlyRepository jewerlyRepository) {
        this.jewerlyRepository = jewerlyRepository;
    }

    //CREATE
    @Override
    public void createJewerly(Jewerly jewerly) {
        jewerlyRepository.save(jewerly);
    }


}
