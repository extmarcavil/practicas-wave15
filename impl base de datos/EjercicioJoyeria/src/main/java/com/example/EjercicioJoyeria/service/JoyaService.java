package com.example.EjercicioJoyeria.service;

import com.example.EjercicioJoyeria.model.Joya;
import com.example.EjercicioJoyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository)
    {
        this.joyaRepository = joyaRepository;
    }

    public Joya findJoya(Long id){
        return joyaRepository
                .findById(id)
                .orElse(null);
    }


    @Override
    public String createJoya(Joya joya) {
        joyaRepository.save(joya);
        return "Nueva joya creada";
    }

    @Override
    public List<Joya> listaJoyas() {
        return joyaRepository.findAll();
    }

    @Override
    public String deleteJoya(Long id) {
        Joya joyaOriginal = this.findJoya(id);
        joyaRepository.delete(joyaOriginal);
        return "Joya borrada correctamente";
    }

    @Override
    public String updateJoya(Long id, Joya joya) {
        Joya joyaOriginal = this.findJoya(id);
        joyaOriginal.setNombre(joya.getNombre());
        joyaOriginal.setMaterial(joya.getMaterial());
        joyaOriginal.setParticularidad(joya.getParticularidad());
        joyaOriginal.setPeso(joya.getPeso());
        joyaOriginal.setPosee_piedra(joya.isPosee_piedra());
        joyaOriginal.setVentaONo(joya.isVentaONo());
        return "Joya actualizada correctamente";
    }
}
