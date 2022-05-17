package com.example.crudjoyeria.service;

import com.example.crudjoyeria.model.Joya;
import com.example.crudjoyeria.repository.JoyasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyeriaService implements IJoyeriaService {
    private final JoyasRepository repo;

    public JoyeriaService(JoyasRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<Joya> getJoyas() {
        return repo.findAll().stream().filter(Joya::isVentaONo).collect(Collectors.toList());
    }

    @Override
    public Joya saveJoya(Joya joya) {
        return repo.save(joya);
    }

    @Override
    public void deleteJoya(long id) {
        findJoya(id).setVentaONo(false);
    }

    @Override
    public Joya findJoya(long id) {
        return repo.getById(id);
    }

    @Override
    public Joya updateJoya(Long id, Joya joya) {
        //findJoya(id);
        return saveJoya(joya);
    }
}
