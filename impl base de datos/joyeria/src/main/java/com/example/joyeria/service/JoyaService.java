package com.example.joyeria.service;

import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService {

    private final IJoyaRepository repository;

    public JoyaService(IJoyaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoyas() {
        return repository.findAll().stream().filter(Joya::getVentaONo).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Long saveJoya(Joya joya) {
        joya.setVentaONo(true);
        repository.save(joya);

        return joya.getId();
    }

    @Override
    @Transactional()
    public void deleteJoya(Long id) {
        Joya joya = this.findJoya(id);
        if (joya == null) {
            throw new RuntimeException("Joya no encontrada");
        }
        joya.setVentaONo(false);
        repository.save(joya);
    }

    @Override
    @Transactional(readOnly = true)
    public Joya findJoya(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Joya updateJoya(Long id, Joya joya) {
        Joya newJoya = this.findJoya(id);

        newJoya.setNombre(joya.getNombre());
        newJoya.setMaterial(joya.getMaterial());
        newJoya.setPeso(joya.getPeso());
        newJoya.setParticularidad(joya.getParticularidad());
        newJoya.setPoseePiedra(joya.getPoseePiedra());
        newJoya.setVentaONo(joya.getVentaONo());
        this.saveJoya(newJoya);

        return newJoya;
    }
}
