package asteroid;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Nave N1 = new Nave("N1", 90, 45);
        Participante P1 = new Participante("P1", N1);

        ArrayList<Nave> F1 = new ArrayList<>();
        F1.add(new Nave("F1N1", 87, 12));
        F1.add(new Nave("F1N2", 76, 30));
        F1.add(new Nave("F1N3", 28, 17));

        Participante P2 = new Participante("P2", new Flota(F1));

        ArrayList<Participante> participantes = new ArrayList<>();
        participantes.add(P1);
        participantes.add(P2);

        System.out.print("Para iniciar ingresa coordenadas del blanco \n x:");
        int x = scanner.nextInt();
        System.out.print("y: ");
        int y = scanner.nextInt();

        System.out.println("---INICIA EL JUEGO---");

        Participante ganador = participantes.get(0);
        double menorResultado = ganador.equipo.medirDistancia(x, y);

        for (Participante participante: participantes) {
            double parcial = participante.equipo.medirDistancia(x, y);
            System.out.println("Parcial: " + parcial);
            if( parcial < menorResultado){
                menorResultado = parcial;
                ganador = participante;
            }
        }

        System.out.println("\n:::::::Participante ganador:::::::");
        System.out.println(ganador.getNombre());
        System.out.println("Con la menor distancia: " + menorResultado);

    }
}
