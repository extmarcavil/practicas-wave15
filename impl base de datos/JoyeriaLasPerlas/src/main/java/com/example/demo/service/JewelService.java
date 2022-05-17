package com.example.demo.service;

import com.example.demo.model.Jewel;
import com.example.demo.repository.IJewelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelService implements IJewelService{

    private final IJewelRepository jewelRepo;

    public JewelService (IJewelRepository jewelRepo)
    {
        this.jewelRepo=jewelRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jewel> getJewels() {
        return jewelRepo.findAll().stream().filter( Jewel::getVentaONo).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Long saveJewel(Jewel jewel) {
        return  jewelRepo.save(jewel).getId();
    }

    @Override
    public void deleteJewel(long id) {

    }

    @Override
    @Transactional(readOnly = true)
    public Jewel findJewel(long id) {
        return jewelRepo.findById(id).orElse(null);
    }
}
