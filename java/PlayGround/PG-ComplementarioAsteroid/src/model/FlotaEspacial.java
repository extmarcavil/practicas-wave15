package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FlotaEspacial extends VehiculoEspacial {

    private ArrayList<NaveEspacial> flotaDeNaveEspacials;
    private double puntajeTotal;

    public FlotaEspacial(List<NaveEspacial> flotaDeNaveEspacials) {
        this.flotaDeNaveEspacials = new ArrayList<>(flotaDeNaveEspacials);
        this.puntajeTotal = 0;
    }

    public double calcularDistancia(Point meoterito) {
        Double sumaDeDistanciasAlMeteorito =
                flotaDeNaveEspacials
                        .stream()
                        .map((x)->x.calcularDistancia(meoterito))
                        .reduce(0D,Double::sum);

        return sumaDeDistanciasAlMeteorito/ flotaDeNaveEspacials.size();
    }

    @Override
    public String imprimirNave() {
        return "Flota espacial reportandose \n"+ (flotaDeNaveEspacials
                .stream()
                .map(NaveEspacial::imprimirNave))
                .reduce("",String::concat);
    }

    public void definirComoGanador(){
         this.puntajeTotal += 1 ;
         this.flotaDeNaveEspacials.stream().forEach(NaveEspacial::definirComoGanador);
    }

    public Double obtenerPuntaje(){
        return puntajeTotal;
    }

    @Override
    public String toString() {
        return "|" + flotaDeNaveEspacials.stream()
                .map(NaveEspacial::toString)
                .map((x)->x+"|")
                .reduce("",String::concat);
    }
}
