package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    private IJoyaRepository repository;

    public JoyaService(IJoyaRepository repository) {
        this.repository = repository;
    }

    @Override
    public String saveJoya(Joya joya) {
        repository.save(joya);
        return "La joya ha sido guardada correctamente";
    }

    @Override
    public List<Joya> getJoyas() {
        return repository.findAll();
    }

    @Override
    public Joya findJoya(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public String deleteJoya(Long id) {
        // Borrado lógico
        Joya joya = this.findJoya(id);
        if(joya != null) {
            joya.setVenta_o_no(false);
            repository.save(joya);
            return "La joya ha sido dada de baja correctamente";
        }
        return "La joya no ha sido encontrada";
    }

    @Override
    public String editJoya(Long id, Joya joya) {
        Joya joyaAModificar = this.findJoya(id);
        if(joyaAModificar != null) {
            this.modificarJoya(joya, joyaAModificar);
            return "La joya ha sido modificada correctamente";
        }
        return "La joya no ha sido encontrada";
    }

    private void modificarJoya(Joya joya, Joya joyaAModificar) {
        joyaAModificar.setMaterial(joya.getMaterial());
        joyaAModificar.setNombre(joya.getNombre());
        joyaAModificar.setParticularidad(joya.getParticularidad());
        joyaAModificar.setPeso(joya.getPeso());
        joyaAModificar.setNro_identificatorio(joya.getNro_identificatorio());
        joyaAModificar.setPosee_piedra(joya.isPosee_piedra());
        joyaAModificar.setVenta_o_no(joya.isVenta_o_no());

        this.saveJoya(joyaAModificar);
    }
}
