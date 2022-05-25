package com.joyeriaP.joyeriaP.service;

import com.joyeriaP.joyeriaP.Exception.JewelryException;
import com.joyeriaP.joyeriaP.model.Jewelry;
import com.joyeriaP.joyeriaP.repository.IJewelryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryService implements IJewelryService {
    @Autowired
    private IJewelryRepository ijewelryRepository;

    @Override
    public Jewelry saveJewelry(Jewelry j) {
       return ijewelryRepository.save(j);
    }

    @Override
    public List<Jewelry> getAllJewelry() {
        return ijewelryRepository.findAllByIsSelledIsTrue();
    }

    @Override
    public Jewelry deleteJewelry(Long id) {

        Jewelry jewelry = ijewelryRepository.findById(id).orElseThrow(()->new JewelryException("Does not exist any jewel with that Id"));
        jewelry.setIsSelled(false);
        ijewelryRepository.save(jewelry);
        return jewelry;
    }

    @Override
    public Jewelry updateJewelry(Jewelry j, Long id) {
       Jewelry jewelry = ijewelryRepository.findById(id).orElseThrow(()->new JewelryException("Does not exist any jewel with that Id"));

            jewelry.setName(j.getName());
            jewelry.setMaterial(j.getMaterial());
            jewelry.setWeight(j.getWeight());
            jewelry.setParticularity(j.getParticularity());
            jewelry.setHas_stone(j.getHas_stone());
            jewelry.setHas_stone(j.getHas_stone());
            ijewelryRepository.save(jewelry);
            return jewelry;
    }

}
