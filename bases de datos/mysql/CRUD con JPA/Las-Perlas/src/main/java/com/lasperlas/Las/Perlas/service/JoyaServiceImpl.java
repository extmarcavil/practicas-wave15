package com.lasperlas.Las.Perlas.service;

import com.lasperlas.Las.Perlas.dto.requestDTO.RequestJoyaDTO;
import com.lasperlas.Las.Perlas.dto.responseDTO.ResponseJoyaDTO;
import com.lasperlas.Las.Perlas.model.Joya;
import com.lasperlas.Las.Perlas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService{
    private final IJoyaRepository joyaRepository;

    public JoyaServiceImpl(IJoyaRepository joyaRepository1){
        this.joyaRepository = joyaRepository1;
    }

    @Override
    @Transactional
    public List<ResponseJoyaDTO> getJoyas() {
        List<Joya> listJoyas = new ArrayList<>();
        listJoyas = joyaRepository.findAll();


        List<ResponseJoyaDTO> listJoyasResponseDTO = null;

        for(Joya joya : listJoyas){
            listJoyasResponseDTO.add(new ResponseJoyaDTO(joya.getNro_identificatorio(),
                                                       joya.getNombre(),
                                                       joya.getMaterial(),
                                                       joya.getPeso(),
                                                       joya.getParticularidad(),
                                                       joya.isPosee_piedra(),
                                                       joya.isVentaONo(),"hoal"));
        }

        return listJoyasResponseDTO;
    }

    @Override
    @Transactional
    public ResponseJoyaDTO saveJoya(RequestJoyaDTO joyaParam) {
        Joya joya = new Joya(joyaParam.getNro_identificatorio(),
                             joyaParam.getNombre(),
                             joyaParam.getMaterial(),
                             joyaParam.getPeso(),
                             joyaParam.getParticularidad(),
                             joyaParam.isPosee_piedra(),
                             joyaParam.isVentaONo());
        joyaRepository.save(joya);

        ResponseJoyaDTO respuesta = new ResponseJoyaDTO(joya.getNro_identificatorio(),
                                                        joya.getNombre(),
                                                        joya.getMaterial(),
                                                        joya.getPeso(),
                                                        joya.getParticularidad(),
                                                        joya.isPosee_piedra(),
                                                        joya.isVentaONo(),
                                                        "Todo OK");
        return respuesta;
    }

    @Override
    @Transactional
    public void deleteJoya(Long id) {
        joyaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Joya findJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        return joya;
    }
}
