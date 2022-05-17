package com.bootcamp.jewerly.service;

import com.bootcamp.jewerly.model.Jewel;
import com.bootcamp.jewerly.repository.JewerlyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewerlyService implements IJewerlyService{

    private final JewerlyRepository jewerlyRepository;

    public JewerlyService(JewerlyRepository jewerlyRepository) {
        this.jewerlyRepository = jewerlyRepository;
    }

    @Override
    @Transactional( readOnly = true)
    public List<Jewel> getJewels() {
        List<Jewel> jewelList = jewerlyRepository.findAllBySaleOrNot(true);
        return jewelList;
    }

    @Override
    @Transactional
    public Long saveJewel(Jewel jewel) {
        Jewel jewel1 = jewerlyRepository.save(jewel);
        return jewel1.getIdentification_num();
    }

    @Override
    @Transactional
    public void deleteJewel(long id) {
        Jewel jewel = jewerlyRepository.findById(id).orElseThrow(()-> new RuntimeException());
        jewel.setSaleOrNot(false);
        jewerlyRepository.save(jewel);


    }

    @Override
    @Transactional( readOnly = true)
    public Jewel findJewel(long id) {
        Jewel jewel = jewerlyRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return jewel;
    }
}
