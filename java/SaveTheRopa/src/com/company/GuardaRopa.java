package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer,List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa() {
        contador=0;
        diccionario= new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador++;
        diccionario.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        diccionario.entrySet().stream().forEach(lista-> {
            System.out.println(lista.getKey());
            System.out.println(lista.getValue().toString());
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }
}
