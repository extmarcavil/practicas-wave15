package modelo;

import java.util.*;

public class GuardaRopa {

    public Map<Integer, List<Prenda>> diccionario = new HashMap<Integer, List<Prenda>>();
    public Integer contador = 0;

    public GuardaRopa() {
    }

    public GuardaRopa(Map<Integer, List<Prenda>> diccionario, Integer contador) {
        this.diccionario = diccionario;
        this.contador = contador;
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

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "diccionario=" + diccionario +
                ", contador=" + contador +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador += 1;
        diccionario.put(contador,listaDePrenda);
        return  contador;
    }

    public void mostrarPrendas(){
        System.out.println(diccionario);
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }


}
