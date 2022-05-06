package com.company;

import java.util.*;

public class GuardaRopa {

    /**
     * Atributos
     */
    private Integer contador;
    private Map<Integer, List<Prenda>> diccionario;

    /**
     * Constructor.
     */
    public GuardaRopa() {
        this.contador = 0;
        this.diccionario = new HashMap<>();
    }


    /**
     * Metodos.
     */
    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        diccionario.put(++contador, listaDePrendas);
        System.out.println("Guardando mi lista en el GuardaRopas con key: " + contador + "\n");
        return contador;
    }

    public void mostrarPrenda() {
        for (List<Prenda> value : diccionario.values()) {
            System.out.println(value + "\n");
        }
    }

    public List<Prenda> devolverPrendas(Integer key) {
        List<Prenda> prendas = Collections.emptyList();

        if (diccionario.containsKey(key)) {
            prendas = diccionario.get(key);
        }
        return prendas;
    }


    /**
     * Getter & Setter
     */
    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }
}



