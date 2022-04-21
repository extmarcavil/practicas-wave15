package com.apicovid19.services;

import com.apicovid19.dtos.SintomaDTO;
import com.apicovid19.models.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class SintomaService implements ISintomaService {
    //region Variables
    private ArrayList<Sintoma> listSintomas;
    //endregion

    //region Constructor

    public SintomaService() {
        listSintomas = new ArrayList<>();
    }

    //endregion

    //region Implementacion

    @Override
    public int agregarSintoma(SintomaDTO sintoma) {
        var sintomaModel = new Sintoma();
        sintomaModel.setNombre(sintoma.getNombre());
        sintomaModel.setNivelGravedad(sintoma.getNivelgravedad());
        sintomaModel.setCodigo(nuevoIdSintoma());
        listSintomas.add(sintomaModel);
        return  sintomaModel.getCodigo();
    }

    @Override
    public ArrayList<SintomaDTO> buscarSintomas() {
        var listResult = new ArrayList<SintomaDTO>();
        listSintomas.forEach(item -> {
            var dto = new  SintomaDTO();
            dto.setCodigo(item.getCodigo());
            dto.setNombre(item.getNombre());
            dto.setNivelgravedad(item.getNivelGravedad());
            listResult.add(dto);
        });
        return listResult;
    }

    @Override
    public SintomaDTO sintomaID(int idSintoma) {
        return buscarSintomas().stream().filter(f ->
                f.getCodigo() == idSintoma).findFirst().orElse(null);
    }

    @Override
    public SintomaDTO sintomaNombre(String Nombre) {
        return buscarSintomas().stream().filter(f ->
                f.getNombre().toLowerCase(Locale.ROOT).equals(Nombre.toLowerCase(Locale.ROOT))).findFirst().orElse(null);
    }

    //endregion

    //region privados
    private  int nuevoIdSintoma()
    {
        var idNuevoSintoma = 0;
        if(listSintomas.size() <= 0)
            idNuevoSintoma = 1;
        else
            idNuevoSintoma = listSintomas.get(listSintomas.size() - 1).getCodigo() + 1;

        return  idNuevoSintoma;
    }
    //endregion
}
