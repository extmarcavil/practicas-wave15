package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class GuardaRopa {
    private HashMap<Integer, ArrayList<Prenda>> deposito = new HashMap<>();
    private int contador;

    public GuardaRopa() {
    }

    public Integer guardarPrendas(ArrayList<Prenda> prendas) {
        contador += 1;
        deposito.put(contador, prendas);
        return contador;
    }

    public void mostrarPrendas() {
        deposito.forEach((k,v) -> System.out.println(k + " " + v));
    }

    public ArrayList<Prenda> devolverPrendas(Integer numero) {
        ArrayList<Prenda> p = deposito.get(numero);

        if(p != null) {
            deposito.remove(numero);
        }

        return p;
    }
}
