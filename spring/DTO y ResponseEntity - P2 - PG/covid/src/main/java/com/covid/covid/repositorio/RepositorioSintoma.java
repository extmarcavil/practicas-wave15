package com.covid.covid.repositorio;

import com.covid.covid.dto.PersonaDTO;
import com.covid.covid.dto.SintomaDTO;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class RepositorioSintoma implements IRepositorioSintoma{
    ArrayList<SintomaDTO> listaSintomas = new ArrayList<SintomaDTO>();
    ArrayList<SintomaDTO> listaSintomasAuxiliar = new ArrayList<SintomaDTO>();
    ArrayList<PersonaDTO> listaPersonas = new ArrayList<PersonaDTO>();

    public RepositorioSintoma() {
        this.listaSintomas = listaSintomas;
        this.listaPersonas = listaPersonas;
        inicializarDatos();
    }

    private void inicializarDatos() {
        SintomaDTO dolorMuscular = new SintomaDTO("Codigo-1", "Dolor Muscular","Bajo");
        SintomaDTO dolorCabeza = new SintomaDTO("Codigo-2", "Dolor de Cabeza", "Bajo");
        SintomaDTO dolorPecho = new SintomaDTO("Codigo-3", "Dolor de Pecho", "Alto");
        SintomaDTO Nauceas = new SintomaDTO("Codigo-4", "Nauceas", "Medio");

        listaSintomasAuxiliar.clear();
        listaSintomasAuxiliar.add(dolorCabeza);
        PersonaDTO persona1 = new PersonaDTO(2L, "Matias", "Alvarez", 34, listaSintomasAuxiliar);
        listaSintomas.add(dolorCabeza);
        listaPersonas.add(persona1);

        listaSintomasAuxiliar.clear();
        listaSintomasAuxiliar.add(dolorMuscular);
        listaSintomasAuxiliar.add(dolorPecho);
        PersonaDTO persona2 = new PersonaDTO(2L, "Roberto", "Alvarez", 66, listaSintomasAuxiliar);
        listaSintomas.add(dolorMuscular);
        listaSintomas.add(dolorPecho);
        listaPersonas.add(persona2);

        listaSintomas.clear();
        listaSintomas.add(dolorCabeza);
        PersonaDTO persona3 = new PersonaDTO(2L, "Maria Florencia", "Tuninetti", 30, listaSintomas);
        listaSintomas.add(dolorCabeza);
        listaPersonas.add(persona3);
    }

    @Override
    public ArrayList<SintomaDTO> getTodosLosSintomas() {
        return listaSintomas;
    }

    @Override
    public SintomaDTO getObtenerSintomaPorNombre(String nombre) {
        SintomaDTO sintomaDTO = null;

        for(SintomaDTO sintoma : listaSintomas){
            if(sintoma.getNombre().equals(nombre)){
               sintomaDTO = sintoma;
               break;
            }
        }
        return sintomaDTO;
    }

    @Override
    public ArrayList<PersonaDTO> getTodasLasPersonas() {
        return listaPersonas;
    }
}
