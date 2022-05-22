package com.example.demo.service;

import com.example.demo.DTO.JoyaDTO;
import com.example.demo.DTO.JoyaRespDTO;
import com.example.demo.exception.JewelNotFoundException;
import com.example.demo.model.Joya;
import com.example.demo.repository.IRepoJoya;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceJoya implements IServiceJoya{
    private final IRepoJoya repo;
    private final ModelMapper mapper;

    public ServiceJoya(IRepoJoya repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
    }

    @Override
    @Transactional(readOnly = true)
    public List<JoyaRespDTO> getJoyas() {
        List<Joya> joyas = repo.findAll().stream().filter(f->f.getVentaONo()).collect(Collectors.toList());
        List<JoyaRespDTO> joyaResp = joyas.stream().map(j->mapper.map(j,JoyaRespDTO.class)).collect(Collectors.toList());
        return joyaResp;
    }

    @Override
    @Transactional
    public Long saveJoya(JoyaDTO joya) {
        Joya j =repo.save(mapper.map(joya,Joya.class));
        return j.getNro_identificatorio();
    }

    @Override
    @Transactional
    public void deleteJoyaLogico(Long idJoya) {
        Joya j = repo.findById(idJoya).orElseThrow(()->new JewelNotFoundException("No existe la joya con id: " + idJoya));
        j.setVentaONo(false);
        repo.save(j);
    }

    @Override
    @Transactional
    public void deleteJoya(Long idJoya) {
        repo.findById(idJoya).orElseThrow(()->new JewelNotFoundException("No existe la joya con id: " + idJoya));
        repo.deleteById(idJoya);


    }

    @Override
    @Transactional(readOnly = true)
    public JoyaRespDTO findJoya(Long idJoya) {
        Joya joya = repo.findById(idJoya).orElseThrow(()->new JewelNotFoundException("No existe la joya con id: " + idJoya));
        return mapper.map(joya, JoyaRespDTO.class);
    }


    @Override
    @Transactional
    public void editJoya(Long id, JoyaDTO joya) {
        Joya modif = repo.findById(id).orElseThrow(()->new JewelNotFoundException("No existe la joya con id: " + id));

            modif.setMaterial(joya.getMaterial());
            modif.setNombre(joya.getNombre());
            modif.setParticularidad(joya.getParticularidad());
            modif.setPeso(joya.getPeso());
            modif.setVentaONo(joya.getVentaONo());
            modif.setPosee_piedra(joya.getPosee_piedra());
            repo.save(modif);



    }
}
