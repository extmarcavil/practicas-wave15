package com.apideportistas.services;

import com.apideportistas.model.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IDeporteService {

    int agregarDeporte(Deporte deporte);

    ArrayList<Deporte> obtenerDeportes();

    Deporte deportebyNombre(String deporteNombre) throws Exception;

    Deporte deportebyId(int idDeporte) throws Exception;
}
