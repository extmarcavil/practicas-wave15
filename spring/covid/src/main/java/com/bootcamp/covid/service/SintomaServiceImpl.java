package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.PacienteDto;
import com.bootcamp.covid.dto.SintomaDto;
import com.bootcamp.covid.repository.ISintomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SintomaServiceImpl implements ISintomaService {

    /**
     * Injection Of Dependency by Constructor
     */
    ISintomaRepository repository;

    public SintomaServiceImpl(ISintomaRepository repository) {
        this.repository = repository;
    }

    /**
     * Metodos
     *
     * @return
     */

    public List<SintomaDto> getSymptoms() {
        return repository.getAllSymptoms();
    }

    public SintomaDto getSymptomDTO(String name) {
        try {
            SintomaDto symptom = repository.getSymptomByName(name)
                    .orElseThrow(() -> new RuntimeException("NOT FOUND"));

            return symptom;

        } catch (RuntimeException e) {
            return new SintomaDto("ERROR", e.getMessage(), "NONE");
        }
    }

    public List<PacienteDto> getPatients() {
        /**
         * Recibo una lista de personas en riesgo.
         */
        List<PacienteDto> patients = repository.getRiskpeople()
                .stream()
                .map(riskPersons -> new PacienteDto(riskPersons.getName(), riskPersons.getLastName(), riskPersons.getSymptoms()))
                .collect(Collectors.toList());
        /**
         * Retorno una lista de pacientes
         */
        return patients;
    }

}
