package com.modulo6.covid19.service.impl;

import com.modulo6.covid19.model.PacienteDTO;
import com.modulo6.covid19.model.PersonaDTO;
import com.modulo6.covid19.repository.SintomaRepository;
import com.modulo6.covid19.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    SintomaRepository sintopmaRepository;

    public List<PacienteDTO> getPacientesMayores() {

        List<PacienteDTO> pacientes= sintopmaRepository.getPersonasMayores()
                .stream()
                .map(mayores -> new PacienteDTO(mayores.getNombre(), mayores.getApellido(), mayores.getSintomas()))
                .collect(Collectors.toList());
        return pacientes;

    }
}
