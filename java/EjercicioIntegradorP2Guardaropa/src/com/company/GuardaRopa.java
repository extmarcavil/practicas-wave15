package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Integer identificador;
    private Map<Integer, List<Prenda>> diccionario;

    public GuardaRopa() {
        this.identificador = 1;
        this.diccionario = new HashMap<>();
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "identificador=" + identificador +
                ", diccionario=" + diccionario +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        int contador = identificador;
        diccionario.put(contador, listaDePrenda);
        System.out.println("Se guarda la prenda con el identificador " + contador);
        identificador++;
        return contador;

    }

    public void mostrarPrendas() {
        for (Integer id : diccionario.keySet()){
            List<Prenda> listaDePrendas = diccionario.get(id);
            System.out.println(listaDePrendas);
        }
    }

    public List<Prenda> devolverPrendas(Integer identificador) {
        return diccionario.remove(identificador);
    }

}
