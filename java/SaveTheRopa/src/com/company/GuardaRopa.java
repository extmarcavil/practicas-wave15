package com.company;

import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer contador;
    private Map<Integer, List<Prenda>> guardaRopa;



    public Integer guardarPrendas(List<Prenda> listaDePrenda){
            guardaRopa.put(contador++,listaDePrenda);
        return contador;
    }

    /*Constructor
     **/

    public GuardaRopa(Map<Integer, List<Prenda>> diccionario) {
        this.guardaRopa = diccionario;
    }

    public Map<Integer, List<Prenda>> getGuardaRopa() {
        return guardaRopa;
    }

    public void setGuardaRopa(Map<Integer, List<Prenda>> guardaRopa) {
        this.guardaRopa = guardaRopa;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "contador=" + contador +
                ", diccionario=" + guardaRopa +
                '}';
    }

    public void mostrarPrendas(){
        guardaRopa.toString();
    }

    /*
    Constructor contador

    **/

    public GuardaRopa(){
        this.contador = 0;
    }

    public GuardaRopa(Integer contador, Map<Integer, List<Prenda>> guardaRopa) {
        this.contador = 0;
        this.guardaRopa = guardaRopa;
    }
}
