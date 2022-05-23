package com.bootcamp.joyeria.Service.Implementaciones;

import com.bootcamp.joyeria.Dto.Request.JoyaRequestDTO;
import com.bootcamp.joyeria.Model.Joya;
import com.bootcamp.joyeria.Repository.JoyeriaRepository;
import com.bootcamp.joyeria.Service.Interfaces.JoyeriaInterface;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoyeriaImp implements JoyeriaInterface {
    private final JoyeriaRepository repo;

    private final ModelMapper mapper;

    public JoyeriaImp(JoyeriaRepository joyeriaRepository, ModelMapper mapper) {
        this.repo = joyeriaRepository;
        this.mapper = mapper;
    }


    @Override
    public void guardarJoya(JoyaRequestDTO joyaRequestDTO) {
       Joya joya = mapper.map(joyaRequestDTO, Joya.class);
        repo.save(joya);
    }

    @Override
    public void actualizarJoya(Long id, JoyaRequestDTO joyaRequestDTO) {
        Joya joya = mapper.map(joyaRequestDTO, Joya.class);
        repo.save(joya);
    }

    @Override
    public void eliminarJoya(Long id) {
        Joya joya = repo.findById(id).orElse(null);
        try{
            repo.delete(joya);
        }catch (Exception e){
            System.out.println("No se puede eliminar");
            return;
        }
    }

    @Override
    public Joya buscarJoya(Long id) {

        Joya joya = repo.findById(id).orElse(null);
        return joya;
    }

    @Override
    public List<Joya> listarJoyas() {
        return repo.findAll();
    }

    @Override
    public List<JoyaRequestDTO> listarJoyasVendidas() {
        List<Joya> joyas = repo.findAll();
        List<JoyaRequestDTO> joyasDTO = new ArrayList<>();

        joyas.forEach((joya)->{
            if(joya.isVentaONo()){
                joyasDTO.add(mapper.map(joya,JoyaRequestDTO.class));
            }
        });

        return joyasDTO;
    }


}
