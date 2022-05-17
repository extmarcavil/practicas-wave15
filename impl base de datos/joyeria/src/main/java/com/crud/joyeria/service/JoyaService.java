package com.crud.joyeria.service;

import com.crud.joyeria.model.Joya;
import com.crud.joyeria.repository.JoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JoyaService {

    @Autowired
    private JoyaRepository joyaRepository;

    public void add(Joya joya) {
        joyaRepository.save(joya);
    }
    public void delete(Long id){
        Joya j = joyaRepository.findById(id).orElse(null);

        if ( ! j.getVentaONo()) {
            joyaRepository.deleteById(id);
        }
    }

    public List<Joya> listAll(){
        return joyaRepository.findAll();
    }

    public void update(Long id){
        Joya newJoya = joyaRepository.findById(id).orElse(null);
        newJoya.setMaterial("Quarzo");
        newJoya.setNombre("Milenial Jewel");
        joyaRepository.save(newJoya);
    }
}
