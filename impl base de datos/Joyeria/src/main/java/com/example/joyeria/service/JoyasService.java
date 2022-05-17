package com.example.joyeria.service;

import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyasService implements IJoyasService {

    private IJoyasRepository joyaRepository;

    public JoyasService(IJoyasRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional
    public Joya saveJoya(Joya j) {
        Joya joya = joyaRepository.save(j);
        return joya;
    }

    @Override
    @Transactional
    public void deleteJoya(long id) {
        Joya j = findJoya(id);
        j.setVentaONo(false);
        joyaRepository.save(j);
    }

    @Override
    @Transactional(readOnly = true)
    public Joya findJoya(long id) {
        Joya j = joyaRepository.findById(id).orElse(null);
        return j.isVentaONo()?j:null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoyas() {
        List<Joya> allJoyas = joyaRepository.findAll();
        List<Joya> joyas = allJoyas.stream().filter(j -> j.isVentaONo())
                                            .collect(Collectors.toList());
        return joyas;
    }
}
