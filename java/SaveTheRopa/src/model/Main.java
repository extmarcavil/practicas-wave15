package model;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Prenda remera = new Prenda("adidas", "remera");
        Prenda campera = new Prenda("adidas", "campera");
        Prenda buzo = new Prenda("adidas", "buzo");
        Prenda joggin = new Prenda("nike", "joggin");
        Prenda remeraNike = new Prenda("nike", "remera");
        Prenda musculosa = new Prenda("Puma", "musculosa");
        Prenda zapatillas = new Prenda("Puma", "zapatillas");

        List<Prenda> listaAdidas = new ArrayList<>();
        listaAdidas.add(remera);
        listaAdidas.add(campera);
        listaAdidas.add(buzo);

        List<Prenda> listaNike = new ArrayList<>();
        listaNike.add(joggin);
        listaNike.add(remeraNike);

        List<Prenda> listaPuma = new ArrayList<>();
        listaPuma.add(musculosa);
        listaPuma.add(zapatillas);

        GuardaRopa guardarropa = new GuardaRopa();
        int idAdidas = guardarropa.guardarPrendas(listaAdidas);
        int idNike = guardarropa.guardarPrendas(listaNike);
        int idPuma = guardarropa.guardarPrendas(listaPuma);

        guardarropa.mostrarPrendas();

        List<Prenda> reclamarAdidas = guardarropa.devolverPrendas(idAdidas);
        System.out.println(reclamarAdidas);

    }

}
