package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    HashMap<Integer, List<Prenda>> diccionarioPrendas;
    int contador;


    public GuardaRopa() {
        this.contador = 1;
        diccionarioPrendas = new HashMap<>();
    }


    public Integer guardaRopa(List<Prenda> listaPrendas) {
        this.diccionarioPrendas.put(contador, listaPrendas);
        int devuelvo = contador;
        contador++;
        return devuelvo;
    }

    public void mostrarPrendas() {
        diccionarioPrendas.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + recorrerList(entry.getValue()));
        });
    }

    private String recorrerList(List<Prenda> list){
        String conjunto = "";

        for(int   i= 0; i < list.size(); i++){
             conjunto += list.get(i).toString() + "\t";
        }
        return conjunto;

    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionarioPrendas.get(numero);
    }


}
