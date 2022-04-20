package com.apideportistas.services;

import com.apideportistas.model.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class DeporteService  implements IDeporteService{

    //region Variables
    private ArrayList<Deporte> listDeportes;
    //endregion

    //region Constructor

    public DeporteService() {
        this.listDeportes = new ArrayList<>();
    }

    //endregion



    //region Implementacion

    @Override
    public int agregarDeporte(Deporte deporte)  {
        int id = 0;
        if(listDeportes.size() <= 0)
            id = 1;
        else
          id =  listDeportes.get(listDeportes.size() - 1).getIdDeporte() + 1;

        deporte.setIdDeporte(id);
        this.listDeportes.add(deporte);
        return id;
    }

    @Override
    public ArrayList<Deporte> obtenerDeportes() {
        return listDeportes;
    }

    @Override
    public Deporte deportebyNombre(String deporteNombre) throws Exception {
        if(deporteNombre.isEmpty() || deporteNombre.isBlank())
            throw new Exception("agregue un nombre de deporte valido");

        return  listDeportes.stream().filter(
                        f -> f.Nombre.toLowerCase(Locale.ROOT).equals(deporteNombre.toLowerCase(Locale.ROOT)))
                .findFirst()
                .orElse(null);

    }

    @Override
    public Deporte deportebyId(int idDeporte) throws Exception {
        if(idDeporte <= 0)
            throw new Exception("el identificador del deporte debe ser mayor a cero (0).");

        return  listDeportes.stream().filter(
                        f -> f.getIdDeporte() == idDeporte)
                .findFirst()
                .orElse(null);
    }

    //endregion
}
