package com.bootcamp.joyeria.Service.Implementaciones;

import com.bootcamp.joyeria.Dto.Request.JoyaRequestDTO;
import com.bootcamp.joyeria.Dto.Response.JoyaResponseDTO;
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
    public Long guardarJoya(JoyaRequestDTO joyaRequestDTO) {
        Joya joya = mapper.map(joyaRequestDTO, Joya.class);
        joya.setVentaONo(true);
        repo.save(joya);
        return joya.getNro_identificatorio();
    }

    @Override
    public void actualizarJoya(Long id, JoyaRequestDTO joyaRequestDTO) {
        Joya joya = mapper.map(joyaRequestDTO, Joya.class);
        repo.save(joya);
    }

    @Override
    public void eliminarJoya(Long id) {
        Joya joya = repo.findById(id).orElse(null);
        joya.setVentaONo(false);
        repo.save(joya);
    }

    @Override
    public Joya buscarJoya(Long id) {

        Joya joya = repo.findById(id).orElse(null);
        return joya;
    }

    @Override
    public List<JoyaResponseDTO> listarJoyas() {
        List<JoyaResponseDTO> joyasDTO = new ArrayList<>();
        return joyasDTO = repo.findAll().stream()
                .filter(joya -> joya.isVentaONo())
                .map(joya -> mapper.map(joya, JoyaResponseDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<JoyaRequestDTO> listarJoyasVendidas() {
        List<Joya> joyas = repo.findAll();
        List<JoyaRequestDTO> joyasDTO = new ArrayList<>();

        joyas.forEach((joya) -> {
            if (joya.isVentaONo()) {
                joyasDTO.add(mapper.map(joya, JoyaRequestDTO.class));
            }
        });

        return joyasDTO;
    }


}
