package com.muchut.savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    public Map<Integer, List<Prenda>> diccionario = new HashMap<Integer, List<Prenda>>();
    public Integer contador = 0;

    public GuardaRopa() {
    }

    public GuardaRopa(Map<Integer, List<Prenda>> diccionario, Integer contador) {
        this.diccionario = diccionario;
        this.contador = contador;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "diccionario=" + diccionario +
                ", contador=" + contador +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador += 1;
        diccionario.put(contador, listaDePrenda);
        System.out.println("El contador es: " + contador);
        return contador;
    }

    public void mostrarPrendas() {
        //for (Map<Integer, List<Prenda>> i : diccionario) {
          //  System.out.println(i);
        //}
        System.out.println(diccionario);
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        System.out.println("la prenda es: " + diccionario.get(numero));
        return diccionario.get(numero);
    }


    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }
}
