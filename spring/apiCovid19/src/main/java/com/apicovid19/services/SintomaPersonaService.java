package com.apicovid19.services;

import com.apicovid19.dtos.PersonaSintomaAsociadoDTO;
import com.apicovid19.dtos.PersonaSintomaDTO;
import com.apicovid19.dtos.SintomaDTO;
import com.apicovid19.models.PersonaSintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class SintomaPersonaService implements  ISintomaPersonaService{

    //region Variables
    private  ArrayList<PersonaSintoma> listPersonaSintoma;
    @Autowired
    private ISintomaService _sintomaService;
    @Autowired
    private  IPersonaService _personaService;
    //endregion

    //region constructor Publico

    public SintomaPersonaService() {
        listPersonaSintoma = new ArrayList<>();
    }

    //endregion

    //region Implementacion

    @Override
    public boolean agregarSintomaPersona(PersonaSintomaDTO personaSintoma) {
        var model = new PersonaSintoma();
        model.setIdPersona(personaSintoma.getIdpersona());
        model.setIdSintoma(personaSintoma.getIdsintoma());
        listPersonaSintoma.add(model);
        return true;
    }

    @Override
    public ArrayList<PersonaSintomaAsociadoDTO> buscarPersonasSintomas(int Edad) {
        var listResult = new ArrayList<PersonaSintomaAsociadoDTO>();
        var pacientesConSintomas = personaSintomas();
        if(pacientesConSintomas.size() > 0){
            var listSintomasInfo = new ArrayList<SintomaDTO>();
            var pacientes = pacientesConSintomas.stream()
                    .map(m -> m.getIdpersona()).collect(Collectors.toList()).stream().distinct();
            pacientes.forEach(paciente -> {
                var infoPersona = _personaService.personaID(paciente.intValue());

                if(infoPersona.getEdad() >= Edad){
                    listSintomasInfo.clear();
                    var padecimientosPaciente = pacientesConSintomas.stream().filter(f ->
                            f.getIdpersona() == paciente.intValue()).collect(Collectors.toList());

                    padecimientosPaciente.stream().forEach(sintoma ->{
                        listSintomasInfo.add(_sintomaService.sintomaID(sintoma.getIdsintoma()));
                    });

                    var dto = new PersonaSintomaAsociadoDTO();
                    dto.setNombre(infoPersona.getNombre());
                    dto.setApellido(infoPersona.getApellido());
                    dto.setListsintomas(listSintomasInfo);
                    listResult.add(dto);
                }
            });
        }
        return  listResult;
    }

    @Override
    public ArrayList<PersonaSintomaDTO> personaSintomas() {
        var listResult = new ArrayList<PersonaSintomaDTO>();
        listPersonaSintoma.forEach(item ->{
            var dto = new PersonaSintomaDTO();
            dto.setIdpersona(item.getIdPersona());
            dto.setIdsintoma(item.getIdSintoma());
            listResult.add(dto);
        });
        return listResult;
    }

    //endregion
}
