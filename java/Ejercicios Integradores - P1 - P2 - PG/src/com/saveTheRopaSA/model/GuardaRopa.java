package com.saveTheRopaSA.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int identificador = 0;
    private Map<Integer, List<Prenda>> diccionario = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        identificador += 1;
        diccionario.put(identificador, listaDePrenda);
        return identificador;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> prenda : diccionario.entrySet()) {
            System.out.println("Identificador: " + prenda.getKey() + "\nPrendas:" + prenda.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        for (Map.Entry<Integer, List<Prenda>> prenda : diccionario.entrySet()) {
            if(prenda.getKey() == numero){
                return prenda.getValue();
            }
        }
        return new ArrayList<>();
    }
}
