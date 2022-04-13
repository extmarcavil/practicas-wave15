package Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private int contador;
    private HashMap<Integer, List<Prenda>> dicionario;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public HashMap<Integer, List<Prenda>> getDicionario() {
        return dicionario;
    }

    public void setDicionario(HashMap<Integer, List<Prenda>> dicionario) {
        this.dicionario = dicionario;
    }

    //CONSTRUCTOR
    public GuardaRopa() {
        this.contador = 0;
        dicionario = new HashMap<>();
    }


    //AGREGAR PRENDAS
    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador ++;
        System.out.println("Sus prendas fueron guardadas con el id: " + contador);
        dicionario.put(contador, listaDePrenda);
        return contador;
    }

    //MOSTRAR LAS PRENDAS EN EL GUARDAROPAS
    public void mostrarPrendas(){
        System.out.println("----Prendas guardadas----");
        dicionario.forEach((k,l) ->
                    System.out.println("Identificador " + k + " - Prendas: " + l));
    }

    //DEVOLUCION DE PRENDAS
    public List<Prenda> devolverPrenda(Integer numero){
        List<Prenda> listado = dicionario.get(numero);

        if (listado != null)
            dicionario.remove(numero);
        else
            System.out.println("No se encontró la prenda solicitada.");
        return listado;
    }
}
