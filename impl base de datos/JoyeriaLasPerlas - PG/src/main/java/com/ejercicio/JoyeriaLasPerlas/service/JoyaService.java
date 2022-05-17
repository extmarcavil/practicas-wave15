package com.ejercicio.JoyeriaLasPerlas.service;

import com.ejercicio.JoyeriaLasPerlas.model.Joya;
import com.ejercicio.JoyeriaLasPerlas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public List<Joya> getJoyas() {
        List<Joya> joyaList = joyaRepository.findAll()
                .stream()
                .filter(j -> j.isVentaONo())
                .collect(Collectors.toList());
        return joyaList;
    }

    @Override
    public String saveJoya(Joya joya) {
        joyaRepository.save(joya);
        return "La joya se creó correctamente.";
    }

    @Override
    public String deleteJoya(Long id) {
        Joya joya = this.findJoya(id);
        joya.setVentaONo(false);
        this.saveJoya(joya);
        return "La joya " + joya.getNombre() + " ha sido eliminada con éxito.";
    }

    @Override
    public Joya findJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        return joya;
    }

    @Override
    public String editJoya(Long id, Joya joyaAux) {

        Joya joyaOriginal = this.findJoya(id);
        joyaOriginal.setNombre(joyaAux.getNombre());
        joyaOriginal.setMaterial(joyaAux.getMaterial());
        joyaOriginal.setPesoEnGramos(joyaAux.getPesoEnGramos());
        joyaOriginal.setParticularidad(joyaAux.getParticularidad());
        joyaOriginal.setPosee_piedra(joyaAux.isPosee_piedra());
        joyaOriginal.setVentaONo(joyaAux.isVentaONo());

        this.saveJoya(joyaOriginal);

        return "La joya ha sido modificada con éxito.";
    }
}
