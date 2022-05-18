package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.ReqPostJoyaDto;
import com.bootcamp.joyeria.dto.ResPostJoyaDto;
import com.bootcamp.joyeria.dto.ResPostMessageDto;
import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository repository;

    public JoyaService(IJoyaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Joya> getJoyas() {
        List<Joya> joyaList = repository.findAll();
        return joyaList;
    }

    @Override
    public ResPostMessageDto saveJoya(ReqPostJoyaDto joya) {
        Joya joyaTemp = new Joya(joya.getName(), joya.getMaterial(), joya.getPeso(), joya.getParticularidad(),
                joya.getPosee_piedra(), joya.getVenta_o_no());

        repository.save(joyaTemp);

        ResPostMessageDto respuesta = new ResPostMessageDto("JOYA CREADA CON ID: " + joyaTemp.getNro_identificatorio());

        return respuesta;
    }

    @Override
    public ResPostMessageDto deleteJoya(Long id) {
        if(findJoyaById(id).getVenta_o_no()){
            findJoyaById(id).setVenta_o_no(false);
            repository.deleteById(id);
            ResPostMessageDto respuesta = new ResPostMessageDto("JOYA ELIMINADA CON ID: " + repository.findById(id));
            return respuesta;
        }
        ResPostMessageDto respuesta = new ResPostMessageDto("No es posible eliminar la joya");
        return respuesta;
    }

    @Override
    public Joya findJoyaById(Long id) {
        Joya joya = repository.findById(id).orElseThrow(()->new RuntimeException());
        return joya;
    }

    @Override
    public ResPostJoyaDto updateJoya(Long id, ReqPostJoyaDto dto){
        Joya joyaTemp = this.findJoyaById(id);

        if(dto.getName() != null){
            joyaTemp.setName(dto.getName());
        }
        if(dto.getMaterial() != null){
            joyaTemp.setMaterial(dto.getMaterial());
        }
        if(dto.getPeso() != null){
            joyaTemp.setPeso(dto.getPeso());
        }
        if(dto.getParticularidad() != null){
            joyaTemp.setParticularidad(dto.getParticularidad());
        }
        if(dto.getPosee_piedra() != null){
            joyaTemp.setPosee_piedra(dto.getPosee_piedra());
        }
        if(dto.getVenta_o_no() != null){
            joyaTemp.setVenta_o_no(dto.getVenta_o_no());
        }

        joyaTemp = repository.save(joyaTemp);

        ResPostJoyaDto joyaDto = new ResPostJoyaDto(joyaTemp.getNro_identificatorio(), joyaTemp.getName(),
                joyaTemp.getMaterial(), joyaTemp.getPeso(), joyaTemp.getParticularidad(), joyaTemp.getPosee_piedra(),
                joyaTemp.getVenta_o_no());

        return joyaDto;
    }
}
