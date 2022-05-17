package com.joyeria.LasPerlas.service;

import com.joyeria.LasPerlas.model.Joya;
import com.joyeria.LasPerlas.repository.iJoyaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements  IJoyaService{

    private final iJoyaRepository joyaRepo;

    public JoyaService(iJoyaRepository joyaRepo) {
        this.joyaRepo = joyaRepo;
    }

    @Override
    @Transactional
    public List<Joya> getJoyas() {
        return joyaRepo.findAll().stream().filter(Joya::isVentaONo).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveJoya(Joya joya) {
        joyaRepo.save(joya);
    }

    @Override
    @Transactional
    public void deleteJoya(Long id) {
        Joya joya = findJoya(id);
        joya.setVentaONo(false);
        joyaRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Joya findJoya(Long id) {
        return joyaRepo.findById(id).orElse(null);
    }
}
