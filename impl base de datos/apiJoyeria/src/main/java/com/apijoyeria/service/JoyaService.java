package com.apijoyeria.service;

import com.apijoyeria.dto.request.JoyaRequestDTO;
import com.apijoyeria.dto.response.JoyaResponseDTO;
import com.apijoyeria.dto.response.AccionJoyaResponseDTO;
import com.apijoyeria.exception.JoyaNotFoundException;
import com.apijoyeria.model.Joya;
import com.apijoyeria.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService {
    private IJoyaRepository joyaRepository;
    private ModelMapper mapper;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public AccionJoyaResponseDTO crearJoya(JoyaRequestDTO joya) {
       var resultDB = joyaRepository.save(mapper.map(joya,Joya.class));
       return new AccionJoyaResponseDTO("Su nùmero identificatorio es: " + resultDB.getNro_identificatorio());
    }

    @Override
    public List<JoyaResponseDTO> todoJoyas() {
        Type listType = new TypeToken<List<JoyaResponseDTO>>(){}.getType();
        return mapper.map(joyaRepository.findAllByVentaONoIsTrue(),listType);
    }

    @Override
    public AccionJoyaResponseDTO eliminarJoya(int nro_identificatorio) {
        Joya joyaExist = existJoya(nro_identificatorio);
        joyaExist.setVentaONo(false);
        joyaRepository.save(joyaExist);
        return new AccionJoyaResponseDTO("La joya : " + nro_identificatorio + ", se dio de baja exitosamente.");
    }

    @Override
    public JoyaResponseDTO actualizaJoya(int nro_identificatorio, JoyaRequestDTO joya) {
        existJoya(nro_identificatorio);
        Joya updateJoya = mapper.map(joya,Joya.class);
        updateJoya.setNro_identificatorio(nro_identificatorio);
        return mapper.map(joyaRepository.save(updateJoya),JoyaResponseDTO.class);
    }

    private Joya existJoya(int nro_identificatorio){
      return joyaRepository.findById(nro_identificatorio)
                .stream()
                .findFirst()
                .orElseThrow(JoyaNotFoundException::new);
    }
}
