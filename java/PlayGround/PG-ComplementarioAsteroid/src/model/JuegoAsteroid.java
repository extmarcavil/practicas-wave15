package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JuegoAsteroid {

    ArrayList<Point> listaDeMeteoritos;
    HashMap<String, VehiculoEspacial> listaDeNavesAJugar;
    HashMap<Point,ArrayList<Object>> tablaDePosiciones;

    public JuegoAsteroid(ArrayList<Point> listaDeMeteoritos) {
        this.listaDeMeteoritos = new ArrayList<>(listaDeMeteoritos);
        this.listaDeNavesAJugar = new HashMap<>();
        this.tablaDePosiciones = new HashMap<>();
    }

    public void inscribirParticipante(String nombrePersonaje, VehiculoEspacial unaNaveEspacial){
        this.listaDeNavesAJugar.put(nombrePersonaje,unaNaveEspacial);
    }

    public void inscribirParticipante(String nombrePersonaje, List<NaveEspacial> listaDeNaves){
        this.listaDeNavesAJugar.put(nombrePersonaje,new FlotaEspacial(listaDeNaves));
    }

    public void definirPosicionMeteoritos(ArrayList<Point> listaDeMeteoritos){
        this.listaDeMeteoritos = new ArrayList<>(listaDeMeteoritos);
    }

    public void agregarNuevoMeteorito( Point nuevoMeteorito){
        this.listaDeMeteoritos.add(nuevoMeteorito);
    }

    public void computarGanador(){
        for(Point meteorito: listaDeMeteoritos){
            System.out.println("Se aproxima un meteorito localizado en la posicion X:" + meteorito.getX()+ " Y:"+ meteorito.getY());

            double distanciaMinima = 999;
            String participanteGanador = "";

            for(String participante : listaDeNavesAJugar.keySet()){
                System.out.println(participante + ":");
                System.out.println(listaDeNavesAJugar.get(participante).imprimirNave() );

                double distanciaDeLasNavesAlMeteoritoDelJugador = listaDeNavesAJugar.get(participante).calcularDistancia(meteorito);
                System.out.println("Ditancia obtenida: "+ distanciaDeLasNavesAlMeteoritoDelJugador);

                if( distanciaDeLasNavesAlMeteoritoDelJugador < distanciaMinima){
                    distanciaMinima = distanciaDeLasNavesAlMeteoritoDelJugador;
                    participanteGanador = participante;
                }
            }
            listaDeNavesAJugar.get(participanteGanador).definirComoGanador();
            tablaDePosiciones.put(meteorito,new ArrayList<>(Arrays.asList(participanteGanador,distanciaMinima)));
            System.out.println("-----------------------");
        }
    }

    public void imprimirTablaDePosiciones() {
        System.out.printf( "%s %22s %11s %25s\n","Objetivo","Participante Ganador","Distancia","Naves Elegidas");
        for(Point meterorito : tablaDePosiciones.keySet() ){
            String participanteGanador = (String) tablaDePosiciones.get(meterorito).get(0);
            Double distanciaMinima = (Double) tablaDePosiciones.get(meterorito).get(1);
            VehiculoEspacial navesElegidasPorElUsuario = listaDeNavesAJugar.get(participanteGanador);
            System.out.printf( "%.01f,%-10.01f %-20s %-15.02f %-30s \n",meterorito.getX(),meterorito.getY(),participanteGanador,distanciaMinima,navesElegidasPorElUsuario);
        }
    }
}
