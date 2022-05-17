package com.example.CrudConJPAJoyeriaLasPerlas.Service;

import com.example.CrudConJPAJoyeriaLasPerlas.Model.Joya;
import com.example.CrudConJPAJoyeriaLasPerlas.Repository.JoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImp implements IJoyaService {

    private final JoyaRepository joyaRepository;

    public JoyaServiceImp(JoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional
    public void saveJoya(Joya joya) {
        joyaRepository.save(joya);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoyas() {
        return joyaRepository.findAll().stream().filter(Joya::isVentaONo).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Joya findJoya(Integer id) {
        return joyaRepository.findById(id).orElse(null);
    }

    @Override
    public Joya updateJoya(Integer id, Joya joya) {
        Joya encontrada = findJoya(id);
        encontrada.setVentaONo(joya.isVentaONo());
        encontrada.setMaterial(joya.getMaterial());
        encontrada.setParticularidad(joya.getParticularidad());
        encontrada.setNombre(joya.getNombre());
        encontrada.setPosePiedra(joya.isPosePiedra());
        encontrada.setPeso(joya.getPeso());

        joyaRepository.save(encontrada);
        return encontrada;

    }

    @Override
    public void deleteJoya(Integer id) {
        Joya encontrada = findJoya(id);
        encontrada.setVentaONo(false);
        saveJoya(encontrada);
    }

}
