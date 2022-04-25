package ejercicioAsteroid;

/*
Un juego llamado Asteroid, consiste en acumular puntos cuando destruye un asteroide. Los participantes pueden poseer una nave
simple o una flota de naves simples. Las naves poseen un nombre, una ubicación en coordenadas (x, y) y una puntuación inicial
de cero. Las flota de naves simples solo poseen una lista de naves simples. Cuando se indica unas coordenadas, la nave que gana
el punto será aquella que esté más cerca, donde la distancia será la(x1-x2)2+(y1-y2)2 , pero en el caso de una flota de naves,
la distancia será el promedio de distancias de las naves de la flota.
Para poder iniciar el juego, se deben inscribir los participantes en una lista y se inicia el juego cuando se pasa en forma de
arreglo las coordenadas donde los blancos aparecerán. Al finalizar se mostrará la nave o flota de naves ganadora que acumuló
más puntos, también se deberá mostrar los resultados obtenidos para cada coordenada ingresada.
Para desarrollar este ejercicio, se recomienda el uso de interfaces, con el uso del patrón de diseño Composite.
*/

import ejercicioAsteroid.clases.Flota;
import ejercicioAsteroid.clases.Nave;
import ejercicioAsteroid.clases.Participante;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class EjercicioAsteroid {

    public static void main(String[] args) {

        ArrayList<Participante> participantes = new ArrayList<>();

        ArrayList<Point> asteroides = new ArrayList<>();
        asteroides.add(new Point(5,2));
        asteroides.add(new Point(0,4));
        asteroides.add(new Point(-1,7));
        asteroides.add(new Point(9,2));
        asteroides.add(new Point(-4,-3));

        Nave ussEnterprise = new Nave("USS Enterprise",2,0);
        Nave millenniumFalcon = new Nave("Millennium Falcon",3,7);
        Nave deathStar = new Nave("Death Star",0,-2);
        Nave starKiller = new Nave("Star Killer",-2,-4);
        Nave nebuchadnezzar = new Nave("Nebuchadnezzar",-5,4);

        Flota flota = new Flota(Arrays.asList(ussEnterprise, deathStar));

        participantes.add(new Participante("Han Solo", millenniumFalcon));
        participantes.add(new Participante("Captain Kirk", flota));
        participantes.add(new Participante("Darth Vader", starKiller));
        participantes.add(new Participante("Morfeo", nebuchadnezzar));

        definirGanador(participantes, asteroides);

        mostrarTablaDePosicionesFinal(participantes);
    }

    private static void mostrarTablaDePosicionesFinal(ArrayList<Participante> participantes) {
        participantes.sort(Comparator.comparing(Participante::obtenerPuntuacionParticipante, Comparator.reverseOrder()));

        int posicion = 1;
        System.out.println("Tabla de posiciones:");
        for (Participante participante : participantes) {
            System.out.println(posicion + ") Participante: " + participante.getNombre() + " - Puntos: " + participante.obtenerPuntuacionParticipante());
            posicion+=1;
        }
    }

    public static void definirGanador(ArrayList<Participante> participantes, ArrayList<Point> asteroides){
        int ronda = 1;
        for(Point asteroide: asteroides){
            System.out.println("Asteroide loacalizado en las coordenadas X: " + asteroide.getX()+ ", Y: "+ asteroide.getY());

            //Por cada asteroide seteo como distancia minima la distancia calculada por el primer jugador y lo guardo como ganador
            double distanciaMin = participantes.get(0).getVehiculoEspacial().calcularDistancia(asteroide);
            Participante ganador = participantes.get(0);

            for (Participante participante : participantes){
                participante.getVehiculoEspacial().identificarse();

                double distanciaAlAsteroide = participante.getVehiculoEspacial().calcularDistancia(asteroide);
                System.out.println("Ditancia al asteroide: "+ distanciaAlAsteroide);

                //Si la distancia calculada es menor se modifica la distancia minima y el ganador
                if (distanciaAlAsteroide < distanciaMin){
                    distanciaMin = distanciaAlAsteroide;
                    ganador = participante;
                }
            }

            ganador.getVehiculoEspacial().sumarPuntos();
            System.out.println("El ganador de la ronda " + ronda + " fue " + ganador.getNombre() + " con una distancia igual a " + distanciaMin);
            System.out.println("-----------------------");

            ronda+=1;
        }
    }

}
