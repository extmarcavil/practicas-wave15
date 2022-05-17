package com.bootcamp.joyeriaLasPerlas.service;

import com.bootcamp.joyeriaLasPerlas.model.Joya;
import com.bootcamp.joyeriaLasPerlas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public String saveJoya(Joya joya) {
        joyaRepository.save(joya);
        return "Joya guardada";
    }

    @Override
    public List<Joya> getJoyas() {
        return joyaRepository.findAll();
    }

    @Override
    public Joya findJoya(Long id) {
        return joyaRepository.getById(id);
    }

    @Override
    public String deleteJoya(Long id) {
        Joya joya = this.findJoya(id);
        joya.setVentaONo(false);
        joyaRepository.save(joya);
        return "Joya dada de baja";
    }

    @Override
    public String editJoya(Long id, Joya joya_modif) {

        Joya joya = this.findJoya(id);

        joya.setNombre(joya_modif.getNombre());
        joya.setMaterial(joya_modif.getMaterial());
        joya.setPeso(joya_modif.getPeso());
        joya.setParticularidad(joya_modif.getParticularidad());
        joya.setPosee_piedra(joya_modif.isPosee_piedra());
        joya.setVentaONo(joya_modif.isVentaONo());

        joyaRepository.save(joya);
        return "Modificado correctamente";
    }


}
