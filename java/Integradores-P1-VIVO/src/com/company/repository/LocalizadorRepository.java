package com.company.repository;

import com.company.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository {

    /**
     * Atributos
     */
    private List<Localizador> localizadores;

    /**
     * Contructor
     */
    public LocalizadorRepository() {
        this.localizadores = new ArrayList<>();
    }

    /**
     * Metodos
     */
    public void guardarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
        System.out.println("Localizador almacenado con la informacion: " + localizador);
    }

    /**
     * Getter & Setter
     */
    public List<Localizador> getHistorialDelCliente() {
        return localizadores;
    }

}
