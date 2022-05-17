package com.example.crudjoyeria.service;

import com.example.crudjoyeria.model.Joya;
import com.example.crudjoyeria.repository.JoyasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyeriaService implements IJoyeriaService {
    private final JoyasRepository repo;

    public JoyeriaService(JoyasRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<Joya> getJoyas() {
        return repo.findAll();
    }

    @Override
    public void saveJoya(Joya joya) {
        repo.save(joya);
    }

    @Override
    public void deleteJoya(long id) {
        repo.deleteById(id);
    }

    @Override
    public Joya findJoya(long id) {
        return repo.getById(id);
    }
}
