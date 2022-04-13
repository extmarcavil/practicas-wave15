package com.company;

import java.util.Map;

public class RepositorioCliente {
    Map<int,Localizador> localizadores;

    public RepositorioCliente() {
    }

    public void consultarHistorial(Cliente cliente){

        if (localizadores.size()>2){
            System.out.println("5% de descuento");
        }


    }

    public Map<int, Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(Map<int, Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "localizadores=" + localizadores +
                '}';
    }
}
