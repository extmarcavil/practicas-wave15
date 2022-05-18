package com.example.joyeria.service;

import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements IJoyaService {


    private final IJoyaRepository joyaRepository;

    public JoyaServiceImpl(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoyas() {
        List<Joya> inventario = joyaRepository.findAll();

        List<Joya> response = sell(inventario);

        return response;
    }

    @Override
    @Transactional
    public String saveJoya(Joya joya) {
        Joya response = joyaRepository.save(joya);
        return String.format("Nro Identificatorio: %s", joya.getNroIdentificatorio());
    }

    @Override
    public String deleteJoya(Long id) {
        deleteLogic(id);
        return String.format("Joya Nro Identificatorio: %s ha sido retirada del Inventario de ventas", id);
    }

    @Override
    @Transactional(readOnly = true)
    public Joya findById(Long id) {
        return joyaRepository.findById(id).get();
    }

    @Override
    public Joya update(Joya joya) {
        Joya newJoya = null;
        Joya upd = joyaRepository.findById(joya.getNroIdentificatorio()).orElse(null);

        if (upd != null) {
            newJoya = joyaRepository.save(joya);
        }

        return newJoya;
    }

    private List<Joya> sell(List<Joya> list) {

        List<Joya> logic = list.stream()
                .filter(j -> j.getVentaONo())
                .collect(Collectors.toList());

        return logic;
    }

    private void deleteLogic(Long id) {
        Joya j = joyaRepository.findById(id).orElse(null);
        j.setVentaONo(false);

        joyaRepository.save(j);
    }
}
